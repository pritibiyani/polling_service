package com.polling.polling_service.polling.poll.domain

import com.polling.polling_service.polling.operation.SavePollOperation
import com.polling.polling_service.polling.poll.web.InputPoll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PollService {
    @Autowired
    lateinit var savePollOperation: SavePollOperation


    fun createPoll(inputPoll: InputPoll): OutputPoll {
        return savePollOperation.perform(inputPoll, this.generateLink(inputPoll.name))
    }

    private fun generateLink(name: String): String {
        return ""
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}