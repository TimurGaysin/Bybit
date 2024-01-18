package ru.hh.bybit.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.hh.bybit.ui.presentation.announcement.AnnouncementViewModel

/**
 * View model module
 * @constructor Create empty ViewModel module
 */
val viewModelModule = module {
    viewModel { AnnouncementViewModel(get()) }
}