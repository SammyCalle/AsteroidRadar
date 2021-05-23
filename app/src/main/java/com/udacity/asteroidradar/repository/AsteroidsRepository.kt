package com.udacity.asteroidradar.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.udacity.asteroidradar.api.*
import com.udacity.asteroidradar.database.NasaDataBase
import com.udacity.asteroidradar.database.asDomainModel
import com.udacity.asteroidradar.domain.Asteroid
import com.udacity.asteroidradar.domain.PictureOfDay
import com.udacity.asteroidradar.getCurrentDate
import com.udacity.asteroidradar.getSevenDaysBeforeDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class AsteroidsRepository(private val database: NasaDataBase) {

    val pictureData = MutableLiveData<PictureOfDay>()

    val asteroidsForThisWeek : LiveData<List<Asteroid>> =
        Transformations.map(database.asteroidsDao.getAsteroidsForThisWeek(
            getCurrentDate(),getSevenDaysBeforeDate()
        )){
            it.asDomainModel()
        }

    val asteroidsTodayOnwards :LiveData<List<Asteroid>> =
            Transformations.map(database.asteroidsDao.getAsteroidsFromTodayOnwards(getCurrentDate())){
                it.asDomainModel()
            }
    val asteroids: LiveData<List<Asteroid>> =
            Transformations.map(database.asteroidsDao.getAsteroids()){
                it.asDomainModel()
            }




    fun getPicture() : LiveData<PictureOfDay>{
        Network.asteroids.getTodayImage().enqueue(object : Callback<PictureofDay>{
            override fun onFailure(call: Call<PictureofDay>, t: Throwable) {

            }

            override fun onResponse(call: Call<PictureofDay>, response: Response<PictureofDay>) {
                pictureData.value = response.body()?.toDomainModel()
            }

        })
        return pictureData
    }


    private suspend fun <T> Call<T>.awaitResponse(): Response<T> {
        return suspendCancellableCoroutine { continuation ->
            continuation.invokeOnCancellation {
                cancel()
            }
            enqueue(object : Callback<T>{
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    continuation.resume(response)
                }

            })
        }
    }


    suspend fun refreshDataFromNasa(start_date : String, end_date : String){
        val call = Network.asteroids.getAsteroids(start_date,end_date)
        val response = call.awaitResponse()
        val newList =  parseAsteroidsJsonResult(JSONObject(response.body()!!))
        withContext(Dispatchers.IO){
            database.asteroidsDao.insertAll(newList)
        }
    }
}