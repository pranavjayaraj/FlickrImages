package com.pranavjayaraj.domain.models

class PhotosResModel(
    val id: String?,
    val owner: String?,
    val secret: String?,
    val server: String?,
    val farm: Int?,
    val title: String?,
    val page: Int?
) {
    var refresh:Boolean = false
}