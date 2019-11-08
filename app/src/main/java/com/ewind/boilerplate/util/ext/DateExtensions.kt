package com.ewind.boilerplate.util.ext

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


const val YYYY_MM_DD = "yyyy-MM-dd"
const val DD_MM_YYYY = "dd/MM/yyyy"
const val DD_MMM = "dd MMM"
const val DD = "dd"
const val HH_MM = "h:mm a"
const val DD_MMMM_EEEE = "dd'%s' MMMM, EEEE"
const val DD_MMM_YYYY_H_MM_AP = "dd/MMM/yyyy h:mm a"
const val EEEE_DD_MMMM = "EEEE dd MMMM"
const val YYYY_MM_DD_hh_mm_ss = "yyyy-MM-dd hh:mm:ss"
const val EE_DD_MMM = "EE dd MMM"


fun String.toDate(): Date? {
    val simpleDateFormat = SimpleDateFormat(YYYY_MM_DD, Locale.US)
    return try {
        simpleDateFormat.parse(this)
    } catch (e: ParseException) {
        null
    }
}

fun String.toDateWithTime(): Date? {
    val simpleDateFormat = SimpleDateFormat(YYYY_MM_DD_hh_mm_ss, Locale.US)
    return try {
        simpleDateFormat.parse(this)
    } catch (e: ParseException) {
        null
    }
}

fun Long.toDate(): Date {
    val date = Date()
    date.time = this
    return date
}

fun Date.toCustomDate(format: String): String {
    val simpleDateFormat = SimpleDateFormat(format, Locale.US)
    return simpleDateFormat.format(this)
}

fun String.toCustomDate(format: String): String {
    return this.toDate()?.let {
        it.toCustomDate(format)
    } ?: ""
}

fun Calendar.calculateDays(calendarSec: Calendar): Long {
    val diff = this.timeInMillis - calendarSec.timeInMillis
    return TimeUnit.MILLISECONDS.toDays(diff)
}

fun String.toCustomDateWithPos(): String {
    val suffix = getDayOfMonthSuffix(this.toCustomDate(DD).toInt())
    val customDate = this.toCustomDate(DD_MMMM_EEEE)
    return String.format(customDate, suffix)
}

fun getDayOfMonthSuffix(n: Int): String {
    //checkArgument(n >= 1 && n <= 31, "illegal day of month: $n")
    if (n in 11..13) {
        return "th"
    }
    return when (n % 10) {
        1 -> "st"
        2 -> "nd"
        3 -> "rd"
        else -> "th"
    }
}