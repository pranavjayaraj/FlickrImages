package com.pranavjayaraj.flickrimages.main.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pranavjayaraj.domain.models.PhotosResModel
import com.pranavjayaraj.flickrimages.R
import com.pranavjayaraj.flickrimages.base.BaseAdapterItemClick
import com.pranavjayaraj.flickrimages.base.BaseViewHolder
import com.pranavjayaraj.flickrimages.utils.GlideDelegate

class PhotosAdapter(
    private val itemClick: BaseAdapterItemClick<PhotosResModel>,
    context: Context,
    val glideDelegate: GlideDelegate
) : RecyclerView.Adapter<BaseViewHolder<PhotosResModel>>() {


    private val photosList = ArrayList<PhotosResModel>()

    fun getPhotosList(): ArrayList<PhotosResModel> {
        return photosList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<PhotosResModel> {
            val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
            val holder = PhotosVH(view, glideDelegate = glideDelegate)
            holder.setCallbackListener(itemClick)
            return holder
    }

    fun setData(photos: ArrayList<PhotosResModel>?) {

        var initialPos = photosList.size
        photosList.addAll(photos!!)
        notifyItemRangeInserted(initialPos, photosList.size - 1)
    }

    fun resetData(photos: ArrayList<PhotosResModel>?)
    {
        if(photosList.isNotEmpty()) photosList.clear()
        photosList.addAll(photos!!)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_photo
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<PhotosResModel>,
        position: Int
    ) {
        holder.setData(photosList[position])
    }
}