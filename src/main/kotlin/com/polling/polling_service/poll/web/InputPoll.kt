package com.polling.polling_service.poll.web

data class InputPoll(
        val name: String,
        val description: String,
        val questions : List<InputQuestion>
)