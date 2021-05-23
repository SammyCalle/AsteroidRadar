package com.udacity.asteroidradar

import java.text.SimpleDateFormat
import java.util.*




    fun getCurrentDate() : String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat(Constants.API_QUERY_DATE_FORMAT,Locale.getDefault())
        val currentTime = calendar.time
        return dateFormat.format(currentTime)
    }

    fun getSevenDaysBeforeDate() : String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat(Constants.API_QUERY_DATE_FORMAT,Locale.getDefault())
        calendar.add(Calendar.DAY_OF_YEAR,7)
        val beforeTime = calendar.time
        return dateFormat.format(beforeTime)
    }
