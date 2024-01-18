package ru.hh.bybit.ui.presentation.data

import ru.hh.bybit.domain.model.AnnouncementList

data class AnnouncementListState(
    val isLoading: Boolean = false,
    val data: List<AnnouncementList.AnnouncementInfo>? = null,
    val error: String = ""
)