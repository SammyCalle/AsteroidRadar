package com.udacity.asteroidradar.main

import android.app.Application
import androidx.lifecycle.*
import com.udacity.asteroidradar.database.getDatabase
import com.udacity.asteroidradar.domain.PictureOfDay
import com.udacity.asteroidradar.getCurrentDate
import com.udacity.asteroidradar.getSevenDaysBeforeDate
import com.udacity.asteroidradar.repository.AsteroidsRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val asteroidsRepository = AsteroidsRepository(database)
    private var pictureData : LiveData<PictureOfDay> = MutableLiveData()

    fun getPictureLiveData() : LiveData<PictureOfDay>{
        return pictureData
    }

    init {
        pictureData = asteroidsRepository.getPicture()
        viewModelScope.launch {
            try {
                asteroidsRepository.refreshDataFromNasa(getCurrentDate()
                    , getSevenDaysBeforeDate())
            }catch (e : Exception){
                println(e)
            }

        }

    }

    val asteroidsTodayOnwardsList = asteroidsRepository.asteroidsTodayOnwards

    val asteroidForThisWeek = asteroidsRepository.asteroidsForThisWeek

    val asteroidsList = asteroidsRepository.asteroids

}