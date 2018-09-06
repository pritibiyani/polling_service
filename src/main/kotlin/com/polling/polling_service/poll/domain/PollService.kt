package com.polling.polling_service.poll.domain

//package com.polling.polling_service.poll.domain

import com.polling.polling_service.common.MyDateTime
import com.polling.polling_service.operation.SavePollOperation
import com.polling.polling_service.poll.web.InputPoll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.security.MessageDigest

@Service
class PollService {
    @Autowired
    private lateinit var savePollOperation: SavePollOperation


    fun createPoll(inputPoll: InputPoll): OutputPoll {
        return savePollOperation.perform(inputPoll, this.generateLink(inputPoll.name))
    }


    //    TOdo: Just using name as of now. Later will user name + username
    private fun generateLink(name: String): String {
        val inputString = name + MyDateTime().getCurrentDateTime()
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(inputString.toByteArray())

        return digest.joinToString("") {
            String.format("%02x", it)
        }
    }
}