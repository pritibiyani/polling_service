package com.polling.polling_service.operation

import com.polling.polling_service.poll.domain.OutputPoll
import com.polling.polling_service.poll.web.InputPoll
import org.springframework.stereotype.Component

@Component
interface ISavePollOperation {
    fun perform(inputPoll: InputPoll, link: String): OutputPoll
}

