package ru.hh.bybit.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.hh.bybit.common.ResponseResource
import ru.hh.bybit.data.remote.source.AnnouncementRepository
import ru.hh.bybit.domain.mapper.toAnnouncementList
import ru.hh.bybit.domain.model.AnnouncementList

class AnnouncementUseCase(private val repository: AnnouncementRepository) {

    suspend operator fun invoke(): Flow<ResponseResource<AnnouncementList>> = flow {
        repository.announcements().collect {
            val responseResource = when (it) {
                is ResponseResource.Error -> ResponseResource.error(it.errorMessage.toAnnouncementList())
                is ResponseResource.Success -> ResponseResource.success(it.data.toAnnouncementList())
            }
            emit(responseResource)
        }
    }

}