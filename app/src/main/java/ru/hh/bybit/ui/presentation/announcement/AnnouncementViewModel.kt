package ru.hh.bybit.ui.presentation.announcement

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.hh.bybit.domain.AnnouncementUseCase
import kotlinx.coroutines.flow.onEach
import ru.hh.bybit.common.ResponseResource
import ru.hh.bybit.ui.presentation.data.AnnouncementListState
import kotlinx.coroutines.flow.launchIn

class AnnouncementViewModel(private val useCase: AnnouncementUseCase) : ViewModel() {

    private val _announcementListState = mutableStateOf(AnnouncementListState())
    val announcementListState: State<AnnouncementListState> = _announcementListState

    fun getAnnouncementList() {
        _announcementListState.value = AnnouncementListState(isLoading = true)
        viewModelScope.launch {
            useCase().onEach {
                when (it) {
                    is ResponseResource.Error ->
                        _announcementListState.value =
                            AnnouncementListState(error = it.errorMessage.errorMessage.orEmpty())
                    is ResponseResource.Success ->
                        _announcementListState.value =
                            AnnouncementListState(data = it.data.announcementInfo.orEmpty())
                }
            }.launchIn(viewModelScope)
        }
    }
}