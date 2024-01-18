package ru.hh.bybit.data.remote.source

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.hh.bybit.common.ENDPOINT_MAIN_REQUEST
import ru.hh.bybit.common.ResponseResource
import ru.hh.bybit.data.announcements.response.AnnouncementsResponse
import ru.hh.bybit.domain.repository.AnnouncementRemote

class AnnouncementRemoteImpl(private val client: HttpClient) : AnnouncementRemote {
    override suspend fun announcement(): ResponseResource<AnnouncementsResponse> =
        try {
            val response = client.get(ENDPOINT_MAIN_REQUEST) {

            }.body<AnnouncementsResponse>()
            when (response.result) {
                null -> ResponseResource.error(response)
                else -> ResponseResource.success(response)
            }
        } catch (e: Exception) {
            ResponseResource.error(
                AnnouncementsResponse
                    (error = AnnouncementsResponse.Error("Something bad happened :(+${e.message}"))
            )
        }

}