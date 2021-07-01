package com.pranavjayaraj.domain.models

import com.google.gson.annotations.SerializedName

class PhotosDataRemoteReqModel(
    @SerializedName("text")
    val text:String?,
    @SerializedName("per_page")
    val per_page:Int?,
    @SerializedName("page")
    val page:Int?
)