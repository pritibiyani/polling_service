package com.polling.polling_service.polling.question.domain

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import java.util.*

@TypeAlias("question")
data class QuestionDocument(@Id val id: String,
                            val question: String,
                            val description: String,
                            val pollID: String,
                            val type: String)