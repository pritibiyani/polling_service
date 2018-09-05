package com.polling.polling_service.polling.poll.domain

import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@TypeAlias("PollDocument")
@Document(collection = "polls")
data class PollDocument(val id: String,
                        val name: String,
                        val description: String,
                        val linkID: String)
