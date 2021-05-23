package com.udacity.asteroidradar.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/udacity/asteroidradar/main/AsteroidAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/udacity/asteroidradar/main/AsteroidViewHolder;", "callback", "Lcom/udacity/asteroidradar/main/AsteroidClick;", "(Lcom/udacity/asteroidradar/main/AsteroidClick;)V", "value", "", "Lcom/udacity/asteroidradar/domain/Asteroid;", "asteroids", "getAsteroids", "()Ljava/util/List;", "setAsteroids", "(Ljava/util/List;)V", "getCallback", "()Lcom/udacity/asteroidradar/main/AsteroidClick;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_debug"})
public final class AsteroidAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.udacity.asteroidradar.main.AsteroidViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.udacity.asteroidradar.domain.Asteroid> asteroids;
    @org.jetbrains.annotations.NotNull()
    private final com.udacity.asteroidradar.main.AsteroidClick callback = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.udacity.asteroidradar.domain.Asteroid> getAsteroids() {
        return null;
    }
    
    public final void setAsteroids(@org.jetbrains.annotations.NotNull()
    java.util.List<com.udacity.asteroidradar.domain.Asteroid> value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.udacity.asteroidradar.main.AsteroidViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.udacity.asteroidradar.main.AsteroidViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.udacity.asteroidradar.main.AsteroidClick getCallback() {
        return null;
    }
    
    public AsteroidAdapter(@org.jetbrains.annotations.NotNull()
    com.udacity.asteroidradar.main.AsteroidClick callback) {
        super();
    }
}