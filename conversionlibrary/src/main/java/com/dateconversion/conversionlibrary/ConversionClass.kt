package com.dateconversion.conversionlibrary

import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    object ConversionObject {
        fun convertDateToFormat(dateString: String,
                                fromFormatString: String, toFormatString: String,
                                locale: Locale): String {
            val fromFormat = SimpleDateFormat(fromFormatString, locale)
            val toFormat = SimpleDateFormat(toFormatString, locale)
            return toFormat.format(fromFormat.parse(dateString))
        }
    }
}