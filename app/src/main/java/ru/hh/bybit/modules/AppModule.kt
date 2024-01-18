package ru.hh.bybit.modules

import org.koin.dsl.module
import ru.hh.bybit.common.ktorHttpClient

/**
 * App module
 * @constructor Create empty App module
 */
val appModule = module {
    single { ktorHttpClient }
}