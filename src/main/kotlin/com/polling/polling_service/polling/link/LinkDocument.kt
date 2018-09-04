package com.polling.polling_service.polling.link

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import java.util.*

@TypeAlias("link")
data class LinkDocument(@Id val id: String, val path: String)