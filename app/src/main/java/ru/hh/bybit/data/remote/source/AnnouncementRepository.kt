package ru.hh.bybit.data.remote.source

import kotlinx.coroutines.flow.Flow
import ru.hh.bybit.common.ResponseResource
import ru.hh.bybit.data.announcements.response.AnnouncementsResponse

interface AnnouncementRepository {
    suspend fun announcements(): Flow<ResponseResource<AnnouncementsResponse>>

}