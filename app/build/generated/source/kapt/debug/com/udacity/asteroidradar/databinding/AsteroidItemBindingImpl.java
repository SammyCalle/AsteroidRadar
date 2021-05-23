package com.udacity.asteroidradar.databinding;
import com.udacity.asteroidradar.R;
import com.udacity.asteroidradar.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AsteroidItemBindingImpl extends AsteroidItemBinding implements com.udacity.asteroidradar.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView3;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public AsteroidItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private AsteroidItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.ImageView) bindings[3];
        this.mboundView3.setTag(null);
        this.txtDateInfo.setTag(null);
        this.txtTitle.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.udacity.asteroidradar.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.asteroid == variableId) {
            setAsteroid((com.udacity.asteroidradar.domain.Asteroid) variable);
        }
        else if (BR.asteroidCallback == variableId) {
            setAsteroidCallback((com.udacity.asteroidradar.main.AsteroidClick) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setAsteroid(@Nullable com.udacity.asteroidradar.domain.Asteroid Asteroid) {
        this.mAsteroid = Asteroid;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.asteroid);
        super.requestRebind();
    }
    public void setAsteroidCallback(@Nullable com.udacity.asteroidradar.main.AsteroidClick AsteroidCallback) {
        this.mAsteroidCallback = AsteroidCallback;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.asteroidCallback);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.udacity.asteroidradar.domain.Asteroid asteroid = mAsteroid;
        com.udacity.asteroidradar.main.AsteroidClick asteroidCallback = mAsteroidCallback;
        boolean asteroidPotentiallyHazardous = false;
        java.lang.String asteroidCloseApproachDate = null;
        java.lang.String asteroidCodename = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (asteroid != null) {
                    // read asteroid.potentiallyHazardous
                    asteroidPotentiallyHazardous = asteroid.isPotentiallyHazardous();
                    // read asteroid.closeApproachDate
                    asteroidCloseApproachDate = asteroid.getCloseApproachDate();
                    // read asteroid.codename
                    asteroidCodename = asteroid.getCodename();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            com.udacity.asteroidradar.BindingAdaptersKt.bindAsteroidStatusImage(this.mboundView3, asteroidPotentiallyHazardous);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtDateInfo, asteroidCloseApproachDate);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtTitle, asteroidCodename);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // asteroid
        com.udacity.asteroidradar.domain.Asteroid asteroid = mAsteroid;
        // asteroidCallback != null
        boolean asteroidCallbackJavaLangObjectNull = false;
        // asteroidCallback
        com.udacity.asteroidradar.main.AsteroidClick asteroidCallback = mAsteroidCallback;



        asteroidCallbackJavaLangObjectNull = (asteroidCallback) != (null);
        if (asteroidCallbackJavaLangObjectNull) {



            asteroidCallback.onClick(asteroid);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): asteroid
        flag 1 (0x2L): asteroidCallback
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}