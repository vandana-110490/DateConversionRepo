package com.dateconversion.conversionlibrary

import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    object ConversionObject {
        /**
         * convert date from one format to another
         */
        fun convertStringDateToFormat(dateString: String,
                                      fromFormatString: String, toFormatString: String,
                                      locale: Locale): String {
            val fromFormat = SimpleDateFormat(fromFormatString, locale)
            val toFormat = SimpleDateFormat(toFormatString, locale)
            return toFormat.format(fromFormat.parse(dateString))
        }
    }

    /**
     * convert milliseconds to date format
     */
    fun convertMilliSecondsToFormat(millis: Long, opDateFormat: String,
                                    locale: Locale): String {
        val dateFormatter = SimpleDateFormat(opDateFormat, locale)
        return dateFormatter.format(Date(millis))
    }

    /**
     * get calendar date in specified format
     */
    fun getCalendarDateInFormat(calendar: Calendar, opDateFormat: String, locale: Locale): String {
        val dateFormatter = SimpleDateFormat(opDateFormat, locale)
        return dateFormatter.format(calendar.time)
    }

    fun getFormattedDateTimeAsDay(millis: Long, opDateFormat: String, locale: Locale): String {
        val dateFormatter = SimpleDateFormat(opDateFormat, locale)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = millis
        val yesterday = Calendar.getInstance()
        yesterday.add(Calendar.DAY_OF_MONTH, -1)
        val tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_MONTH, 1)
        when (dateFormatter.format(calendar.time) ==
                (dateFormatter.format(Calendar.getInstance().time))) {
            true -> return "Today"
            false -> when (dateFormatter.format(calendar.time) ==
                    (dateFormatter.format(yesterday.time))) {
                true -> return "Yesterday"
                false -> when (dateFormatter.format(calendar.time) ==
                        (dateFormatter.format(tomorrow.time))) {
                    true -> return "Tomorrow"
                    false -> dateFormatter.format(calendar.time)
                }
            }
        }
        return ""
    }
}