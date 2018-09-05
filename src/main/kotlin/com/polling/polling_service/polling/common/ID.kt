package com.polling.polling_service.polling.common

import java.time.LocalDateTime
import java.util.*


class UniqueIdGenerator{
    companion object Factory{
        private const val nameSpace = "some-namespace"

        fun byName(name: String): String {
            val string = nameSpace + name + LocalDateTime.now()
            return UUID.nameUUIDFromBytes(string.toByteArray()).toString()
        }

        fun byTime(): String {
            return UUID.randomUUID().toString();
        }
    }
}