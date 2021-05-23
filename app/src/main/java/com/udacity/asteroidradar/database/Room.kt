package com.udacity.asteroidradar.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AsteroidsDao {
    @Query("select * from asteroids order by closeApproachDate ASC")
    fun getAsteroids(): LiveData<List<DatabaseAsteroid>>

    @Query("select * from asteroids where closeApproachDate >= :currentDate order by closeApproachDate ASC" )
    fun getAsteroidsFromTodayOnwards(currentDate : String) : LiveData<List<DatabaseAsteroid>>

    @Query("select * from asteroids where closeApproachDate >= :currentDate and closeApproachDate <= :weekAfterDate order by closeApproachDate ASC")
    fun getAsteroidsForThisWeek(currentDate : String, weekAfterDate : String) : LiveData<List<DatabaseAsteroid>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(asteroids: List<DatabaseAsteroid>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPicture(picture : PictureTable)

    @Query("select * from picture")
    fun getPicture() : LiveData<List<PictureTable>>
}

@Database(entities = [DatabaseAsteroid::class,PictureTable::class], version = 1)
abstract class NasaDataBase : RoomDatabase() {
    abstract val asteroidsDao : AsteroidsDao
}

private lateinit var INSTANCE: NasaDataBase

fun getDatabase(context: Context): NasaDataBase {
    synchronized(NasaDataBase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                    NasaDataBase::class.java,
                    "asteroids").build()
        }
    }
    return INSTANCE
}