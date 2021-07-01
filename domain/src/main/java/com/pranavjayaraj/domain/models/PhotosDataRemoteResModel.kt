package com.pranavjayaraj.domain.models

import com.google.gson.annotations.SerializedName

class PhotosDataRemoteResModel(
    @SerializedName("photos")
    val photosPageRemote: PhotosPageRemoteModel
)