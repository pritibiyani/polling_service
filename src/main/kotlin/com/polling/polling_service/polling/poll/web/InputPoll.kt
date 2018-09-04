package com.polling.polling_service.polling.poll.web

data class InputLink(val longURL:String, val shortURL :String)

//type could be enum later
data class InputQuestion(val shortText: String, val description: String, val type: String)

data class InputPoll(
        val name: String,
        val description: String,
        val questions : List<InputQuestion>
)