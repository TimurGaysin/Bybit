package ru.hh.bybit.domain.model


data class AnnouncementList(
    val announcementInfo: List<AnnouncementInfo>? = null,
    val errorMessage: String? = null
) {

    data class AnnouncementInfo(
        val title: String,
        val description: String,
        val url: String
    )




}