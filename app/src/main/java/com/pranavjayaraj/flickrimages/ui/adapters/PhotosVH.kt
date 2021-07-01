package com.pranavjayaraj.flickrimages.ui.adapters

import android.view.View
import com.pranavjayaraj.domain.models.PhotosResModel
import com.pranavjayaraj.flickrimages.base.BaseViewHolder
import com.pranavjayaraj.flickrimages.utils.GlideDelegate
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotosVH(view: View,val glideDelegate: GlideDelegate) : BaseViewHolder<PhotosResModel>(view) {
    var foodDataDetailed: PhotosResModel? = null

    override fun setData(data: PhotosResModel) {
        glideDelegate.loadUrlWithPlaceHolder(
            itemView.photoIv,
            "https://farm${data.farm}.static.flickr.com/${data.server}/${data.id}_${data.secret}_m.jpg",
            -1
        )
        itemView.titleTv.text = data.title.toString()
        foodDataDetailed = data
    }
}