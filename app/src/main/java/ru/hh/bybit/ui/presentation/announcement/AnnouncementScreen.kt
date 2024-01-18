package ru.hh.bybit.ui.presentation.announcement

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import org.koin.androidx.compose.getViewModel
import ru.hh.bybit.R
import ru.hh.bybit.ui.presentation.common.Loader

@Composable
fun AnnouncementScreen(
    viewModel: AnnouncementViewModel = getViewModel()
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val announcementListState = viewModel.announcementListState.value

    DisposableEffect(key1 = lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                viewModel.getAnnouncementList()
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            if (announcementListState.data?.isNotEmpty() == true)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp)
                ) {
                    val friendList = announcementListState.data

                    friendList.forEach {
                        item {
                            AnnouncementListItemRow(announcementData = it)
                        }
                    }
                }
        }

        if (announcementListState.data?.isEmpty() == true)
            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(42.dp),
                painter = painterResource(id = R.drawable.report_icon),
                contentDescription = "No announcements!"
            )

        Loader(isLoading = announcementListState.isLoading)
    }
}
