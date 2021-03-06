package com.udacity.asteroidradar;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u0018\u0010\r\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\"\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u00a8\u0006\u0013"}, d2 = {"bindAsteroidStatusImage", "", "imageView", "Landroid/widget/ImageView;", "isHazardous", "", "bindDetailsStatusImage", "bindTextViewToAstronomicalUnit", "textView", "Landroid/widget/TextView;", "number", "", "bindTextViewToDisplayVelocity", "bindTextViewToKmUnit", "setImageUrl", "url", "", "error", "Landroid/graphics/drawable/Drawable;", "app_debug"})
public final class BindingAdaptersKt {
    
    @androidx.databinding.BindingAdapter(value = {"imageUrl", "error"})
    public static final void setImageUrl(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable error) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"statusIcon"})
    public static final void bindAsteroidStatusImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, boolean isHazardous) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"asteroidStatusImage"})
    public static final void bindDetailsStatusImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, boolean isHazardous) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"astronomicalUnitText"})
    public static final void bindTextViewToAstronomicalUnit(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, double number) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"kmUnitText"})
    public static final void bindTextViewToKmUnit(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, double number) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"velocityText"})
    public static final void bindTextViewToDisplayVelocity(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, double number) {
    }
}