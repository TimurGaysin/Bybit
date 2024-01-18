package ru.hh.bybit.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.hh.bybit.common.ResponseResource
import ru.hh.bybit.data.announcements.response.AnnouncementsResponse
import ru.hh.bybit.data.remote.source.AnnouncementRepository
import ru.hh.bybit.domain.repository.AnnouncementRemote

class AnnouncementRepositoryImpl(private val remote: AnnouncementRemote) : AnnouncementRepository {
    override suspend fun announcements(): Flow<ResponseResource<AnnouncementsResponse>> =
        flow {
            when (val response = remote.announcement()) {
                is ResponseResource.Error -> emit(ResponseResource.error(response.errorMessage))
                is ResponseResource.Success -> emit(ResponseResource.success(response.data))
            }
        }
}