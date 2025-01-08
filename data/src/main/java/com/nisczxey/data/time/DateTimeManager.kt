package com.nisczxey.data.time

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateTimeManager {

    fun getCurrentTime(): String {
        val currentDateAndTime =
            SimpleDateFormat("HH:mm-dd-MM-yy", Locale.getDefault()).format(Date())
        return currentDateAndTime
    }


}