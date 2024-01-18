package ru.hh.bybit.domain.mapper

import ru.hh.bybit.data.announcements.response.AnnouncementsResponse
import ru.hh.bybit.domain.model.AnnouncementList

fun AnnouncementsResponse.toAnnouncementList(): AnnouncementList {
    val announcementList = arrayListOf<AnnouncementList.AnnouncementInfo>()
    result?.list?.forEach {
        announcementList.add(
            AnnouncementList.AnnouncementInfo(
                title =  it.title,
                description = it.description,
                url = it.url
            )
        )
    }
    return AnnouncementList(
        announcementInfo = announcementList,
        errorMessage = error?.message
    )
}