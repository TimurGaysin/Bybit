package ru.hh.bybit.data.announcements.response

import kotlinx.serialization.Serializable
@Serializable
data class AnnouncementsResponse(val retCode: Int?= null, val retMsg: String?= null, val result:Result? = null, val retExtInfo:RetExtInfo?  = null, val time: Long?= null, val error: Error? = null) {


    @Serializable
    data class Result(
        val total: Int,
        val list: Array<Announcement>
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Result

            if (total != other.total) return false
            return list.contentEquals(other.list)
        }

        override fun hashCode(): Int {
            var result = total
            result = 31 * result + list.contentHashCode()
            return result
        }
    }

    @Serializable
    data class Announcement(
        val title: String,
        val description: String,
        val typeData:Type? = null,
        val tags: Array<String>,
        val url:String,
        val dateTimestamp: Long,
        val startDateTimestamp: Long,
        val endDateTimestamp: Long
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Announcement

            if (title != other.title) return false
            if (description != other.description) return false
            if (typeData != other.typeData) return false
            if (!tags.contentEquals(other.tags)) return false
            if (url != other.url) return false
            if (dateTimestamp != other.dateTimestamp) return false
            if (startDateTimestamp != other.startDateTimestamp) return false
            return endDateTimestamp == other.endDateTimestamp
        }

        override fun hashCode(): Int {
            var result = title.hashCode()
            result = 31 * result + description.hashCode()
            result = 31 * result + (typeData?.hashCode() ?: 0)
            result = 31 * result + tags.contentHashCode()
            result = 31 * result + url.hashCode()
            result = 31 * result + dateTimestamp.hashCode()
            result = 31 * result + startDateTimestamp.hashCode()
            result = 31 * result + endDateTimestamp.hashCode()
            return result
        }
    }

    @Serializable
    data class Type(
        val title: String,
        val key: String
    )

    @Serializable
    data class RetExtInfo(val title: String?=null)

    @Serializable
    data class Error(
        val message: String? = null
    )


}