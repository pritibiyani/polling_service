package com.polling.polling_service.polling.operation

import com.polling.polling_service.polling.poll.domain.OutputPoll
import com.polling.polling_service.polling.poll.web.InputPoll

interface ISavePollOperation {
    fun perform(inputPoll: InputPoll, link: String): OutputPoll
}

