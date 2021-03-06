package com.polling.polling_service.poll.web

import com.polling.polling_service.poll.domain.OutputPoll
import com.polling.polling_service.poll.domain.PollService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController()
class PollResource{
    @Autowired
    lateinit var pollService: PollService

    @PostMapping("/poll")
    fun createPoll(@RequestBody inputPoll: InputPoll):ResponseEntity<OutputPoll> {
        val poll = pollService.createPoll(inputPoll)
        return ResponseEntity(poll, HttpStatus.CREATED)
    }
}