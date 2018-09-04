package com.polling.polling_service.polling.poll.domain

import org.springframework.data.repository.CrudRepository
import java.util.*

interface PollRepository : CrudRepository<PollDocument, UUID>