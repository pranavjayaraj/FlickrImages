package com.pranavjayaraj.domain.models

import com.google.gson.annotations.SerializedName

class PhotosPageRemoteModel(
    @SerializedName("page")
    val page:Int?,
    @SerializedName("pages")
    val pages:Int?,
    @SerializedName("perpage")
    val perPage:Int?,
    @SerializedName("total")
    val total:String?,
    @SerializedName("photo")
    val photos:ArrayList<PhotoInfoRemoteModel>
)