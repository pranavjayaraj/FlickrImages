package com.pranavjayaraj.data.services

import com.pranavjayaraj.data.BuildConfig

object Urls {
    const val BASE_URL = BuildConfig.BASE_URL
    const val GET_PHOTO_LIST = "?method=flickr.photos.search&api_key=062a6c0c49e4de1d78497d13a7dbb360&nojsoncallback=1&format=json"
}