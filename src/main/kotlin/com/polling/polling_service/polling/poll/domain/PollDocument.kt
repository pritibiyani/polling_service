package com.polling.polling_service.polling.poll.domain

import org.springframework.data.annotation.TypeAlias

@TypeAlias("poll")
data class PollDocument(val id: String,
                        val name: String,
                        val description: String,
                        val linkID: String)
