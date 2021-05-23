package com.udacity.asteroidradar.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\b\b\u0003\u0010\u0007\u001a\u00020\u0004H\'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0003\u0010\n\u001a\u00020\u0004H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/udacity/asteroidradar/api/AsteroidPerDate;", "", "getAsteroids", "Lretrofit2/Call;", "", "start_date", "end_date", "API_KEY", "getTodayImage", "Lcom/udacity/asteroidradar/api/PictureofDay;", "apiKey", "app_debug"})
public abstract interface AsteroidPerDate {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/planetary/apod")
    public abstract retrofit2.Call<com.udacity.asteroidradar.api.PictureofDay> getTodayImage(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String apiKey);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/neo/rest/v1/feed")
    public abstract retrofit2.Call<java.lang.String> getAsteroids(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "start_date")
    java.lang.String start_date, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "end_date")
    java.lang.String end_date, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "api_key")
    java.lang.String API_KEY);
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}