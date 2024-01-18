package ru.hh.bybit.modules

import org.koin.dsl.module
import ru.hh.bybit.data.remote.source.AnnouncementRepository
import ru.hh.bybit.data.repository.AnnouncementRepositoryImpl

/**
 * Repository module
 * @constructor Create empty Repository module
 */
val repositoryModule = module {
    single<AnnouncementRepository> { AnnouncementRepositoryImpl(get()) }
}