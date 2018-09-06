package com.polling.polling_service.common

import org.joda.time.DateTime


open class DateTimeWrapper {
    fun getCurrentDateTime(): String {
        val time = DateTime.now().toString()
        println("\n\n-- $time --\n\n")
        return time
    }
}