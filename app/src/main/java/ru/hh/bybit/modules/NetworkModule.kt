package ru.hh.bybit.modules


import org.koin.dsl.module
import ru.hh.bybit.data.remote.source.AnnouncementRemoteImpl
import ru.hh.bybit.domain.repository.AnnouncementRemote

/**
 * Network module
 * @constructor Create empty Network module
 */
val networkModule = module {
    single<AnnouncementRemote> { AnnouncementRemoteImpl(get()) }

}