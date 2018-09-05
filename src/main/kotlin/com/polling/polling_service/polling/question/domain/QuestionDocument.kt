package com.polling.polling_service.polling.question.domain

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document

@TypeAlias("QuestionDocument")
@Document(collection = "questions")

data class QuestionDocument(@Id val id: String,
                            val question: String,
                            val description: String,
                            val pollID: String,
                            val type: String)