package com.udacity.asteroidradar.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.databinding.AsteroidItemBinding
import com.udacity.asteroidradar.domain.Asteroid


class AsteroidAdapter(val callback : AsteroidClick) : RecyclerView.Adapter<AsteroidViewHolder>(){

     var asteroids : List<Asteroid> = emptyList()
        set(value){
            field =  value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {
        val withDataBinding: AsteroidItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                AsteroidViewHolder.LAYOUT,
                parent,
                false)
        return AsteroidViewHolder(withDataBinding)
    }

    override fun getItemCount() = asteroids.size

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.asteroid = asteroids[position]
            it.asteroidCallback = callback
        }
    }

}

class AsteroidViewHolder(val viewDataBinding: AsteroidItemBinding):
        RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object{
        @LayoutRes
        val LAYOUT = R.layout.asteroid_item
    }

}

class AsteroidClick(val block: (Asteroid) -> Unit) {
    fun onClick(asteroid: Asteroid) = block(asteroid)
}
