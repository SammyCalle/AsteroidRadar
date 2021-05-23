package com.udacity.asteroidradar.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J$\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\'J\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH\'J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u0003H\'J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\'J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fH\'\u00a8\u0006\u0012"}, d2 = {"Lcom/udacity/asteroidradar/database/AsteroidsDao;", "", "getAsteroids", "Landroidx/lifecycle/LiveData;", "", "Lcom/udacity/asteroidradar/database/DatabaseAsteroid;", "getAsteroidsForThisWeek", "currentDate", "", "weekAfterDate", "getAsteroidsFromTodayOnwards", "getPicture", "Lcom/udacity/asteroidradar/database/PictureTable;", "insertAll", "", "asteroids", "insertPicture", "picture", "app_debug"})
public abstract interface AsteroidsDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from asteroids order by closeApproachDate ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.udacity.asteroidradar.database.DatabaseAsteroid>> getAsteroids();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from asteroids where closeApproachDate >= :currentDate order by closeApproachDate ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.udacity.asteroidradar.database.DatabaseAsteroid>> getAsteroidsFromTodayOnwards(@org.jetbrains.annotations.NotNull()
    java.lang.String currentDate);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from asteroids where closeApproachDate >= :currentDate and closeApproachDate <= :weekAfterDate order by closeApproachDate ASC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.udacity.asteroidradar.database.DatabaseAsteroid>> getAsteroidsForThisWeek(@org.jetbrains.annotations.NotNull()
    java.lang.String currentDate, @org.jetbrains.annotations.NotNull()
    java.lang.String weekAfterDate);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.udacity.asteroidradar.database.DatabaseAsteroid> asteroids);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertPicture(@org.jetbrains.annotations.NotNull()
    com.udacity.asteroidradar.database.PictureTable picture);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from picture")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.udacity.asteroidradar.database.PictureTable>> getPicture();
}