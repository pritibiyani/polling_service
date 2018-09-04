package com.polling.polling_service.polling.link

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LinkRepository : CrudRepository<LinkDocument, UUID>
