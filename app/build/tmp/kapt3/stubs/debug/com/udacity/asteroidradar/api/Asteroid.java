package com.udacity.asteroidradar.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0016\u00a8\u0006\""}, d2 = {"Lcom/udacity/asteroidradar/api/Asteroid;", "", "id", "", "absoluteMagnitudeH", "", "estimatedDiameter", "Lcom/udacity/asteroidradar/api/EstimatedDiameter;", "isPotentiallyHazardousAsteroid", "", "closeApproachData", "", "Lcom/udacity/asteroidradar/api/CloseApproachData;", "(Ljava/lang/String;DLcom/udacity/asteroidradar/api/EstimatedDiameter;ZLjava/util/List;)V", "getAbsoluteMagnitudeH", "()D", "getCloseApproachData", "()Ljava/util/List;", "getEstimatedDiameter", "()Lcom/udacity/asteroidradar/api/EstimatedDiameter;", "getId", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
@com.squareup.moshi.JsonClass(generateAdapter = true)
public final class Asteroid {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    private final double absoluteMagnitudeH = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final com.udacity.asteroidradar.api.EstimatedDiameter estimatedDiameter = null;
    private final boolean isPotentiallyHazardousAsteroid = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.udacity.asteroidradar.api.CloseApproachData> closeApproachData = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final double getAbsoluteMagnitudeH() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.udacity.asteroidradar.api.EstimatedDiameter getEstimatedDiameter() {
        return null;
    }
    
    public final boolean isPotentiallyHazardousAsteroid() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.udacity.asteroidradar.api.CloseApproachData> getCloseApproachData() {
        return null;
    }
    
    public Asteroid(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @com.squareup.moshi.Json(name = "absolute_magnitude_h")
    double absoluteMagnitudeH, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "estimated_diameter")
    com.udacity.asteroidradar.api.EstimatedDiameter estimatedDiameter, @com.squareup.moshi.Json(name = "is_potentially_hazardous_asteroid")
    boolean isPotentiallyHazardousAsteroid, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "close_approach_data")
    java.util.List<com.udacity.asteroidradar.api.CloseApproachData> closeApproachData) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.udacity.asteroidradar.api.EstimatedDiameter component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.udacity.asteroidradar.api.CloseApproachData> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.udacity.asteroidradar.api.Asteroid copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @com.squareup.moshi.Json(name = "absolute_magnitude_h")
    double absoluteMagnitudeH, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "estimated_diameter")
    com.udacity.asteroidradar.api.EstimatedDiameter estimatedDiameter, @com.squareup.moshi.Json(name = "is_potentially_hazardous_asteroid")
    boolean isPotentiallyHazardousAsteroid, @org.jetbrains.annotations.NotNull()
    @com.squareup.moshi.Json(name = "close_approach_data")
    java.util.List<com.udacity.asteroidradar.api.CloseApproachData> closeApproachData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}