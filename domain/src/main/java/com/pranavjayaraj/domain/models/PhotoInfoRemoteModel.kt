package com.pranavjayaraj.domain.models

import com.google.gson.annotations.SerializedName

class PhotoInfoRemoteModel(
    @SerializedName("id")
    val id:String?,
    @SerializedName("owner")
    val owner:String?,
    @SerializedName("secret")
    val secret:String?,
    @SerializedName("server")
    val server:String?,
    @SerializedName("farm")
    val farm:Int?,
    @SerializedName("title")
    val title:String?
)