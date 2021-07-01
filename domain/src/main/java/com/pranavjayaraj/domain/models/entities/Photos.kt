package com.pranavjayaraj.domain.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.pranavjayaraj.domain.models.entities.Photos.Companion.COLUMN_FARM
import com.pranavjayaraj.domain.models.entities.Photos.Companion.COLUMN_ID
import com.pranavjayaraj.domain.models.entities.Photos.Companion.COLUMN_SECRET
import com.pranavjayaraj.domain.models.entities.Photos.Companion.COLUMN_SERVER
import com.pranavjayaraj.domain.models.entities.Photos.Companion.TABLE

@Entity(tableName = TABLE, primaryKeys = [COLUMN_FARM, COLUMN_ID, COLUMN_SECRET, COLUMN_SERVER])
class Photos(
    @ColumnInfo(name = COLUMN_ID)
    val id: String,
    @ColumnInfo(name = COLUMN_OWNER)
    val owner: String,
    @ColumnInfo(name = COLUMN_SECRET)
    val secret: String,
    @ColumnInfo(name = COLUMN_SERVER)
    val server: String,
    @ColumnInfo(name = COLUMN_FARM)
    val farm: Int,
    @ColumnInfo(name = COLUMN_TITLE)
    val title: String,
    @ColumnInfo(name = COLUMN_PAGE)
    val page: Int
) {
    companion object {
        const val TABLE = "photos"
        const val COLUMN_FARM = "farm"
        const val COLUMN_SERVER = "server"
        const val COLUMN_ID = "id"
        const val COLUMN_SECRET = "secret"
        const val COLUMN_TITLE = "title"
        const val COLUMN_PAGE = "page"
        const val COLUMN_OWNER = "owner"
    }
}