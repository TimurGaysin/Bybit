package ru.hh.bybit.modules


import org.koin.dsl.module
import ru.hh.bybit.domain.AnnouncementUseCase

/**
 * Repositories module
 * @constructor Create empty Repositories module
 */
val useCaseModule = module {
    single { AnnouncementUseCase(get()) }
}