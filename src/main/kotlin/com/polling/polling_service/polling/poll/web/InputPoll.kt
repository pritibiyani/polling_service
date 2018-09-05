package com.polling.polling_service.polling.poll.web

data class InputPoll(
        val name: String,
        val description: String,
        val questions : List<InputQuestion>
)