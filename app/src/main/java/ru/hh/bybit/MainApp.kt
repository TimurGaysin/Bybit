package ru.hh.bybit

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.hh.bybit.modules.appModule
import ru.hh.bybit.modules.networkModule
import ru.hh.bybit.modules.repositoryModule
import ru.hh.bybit.modules.useCaseModule
import ru.hh.bybit.modules.viewModelModule

class MainApp  : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(
                appModule,
                networkModule,
                useCaseModule,
                viewModelModule,
                repositoryModule
            )
        }
    }
}