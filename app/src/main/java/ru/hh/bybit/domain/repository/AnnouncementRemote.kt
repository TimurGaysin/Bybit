package ru.hh.bybit.domain.repository

import ru.hh.bybit.common.ResponseResource
import ru.hh.bybit.data.announcements.response.AnnouncementsResponse

interface AnnouncementRemote {
    suspend fun announcement(): ResponseResource<AnnouncementsResponse>
}