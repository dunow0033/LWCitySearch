package com.express.android.lwcitysearch

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.express.android.lwcitysearch.databinding.RecyclerviewRowBinding

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items = ArrayList<RecyclerData>()

    fun setListData(data: ArrayList<RecyclerData>) {
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RecyclerviewRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(val binding: RecyclerviewRowBinding): RecyclerView.ViewHolder(binding.root) {

        val tvTitle = binding.tvTitle
        val tvDescription = binding.tvDesc
        val imageThumb = binding.imageThumb

        fun bind(data: RecyclerData) {
            tvTitle.text = data.name
            if(!TextUtils.isEmpty(data.description)) {
                tvDescription.text = data.description
            } else {
                tvDescription.text = "No Desc available"
            }

            val url = data.owner.avatar_url
            Glide.with(binding.imageThumb)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.default_thumb)
                .error(R.drawable.default_thumb)
                .fallback(R.drawable.default_thumb)
                .into(imageThumb)
        }
    }
}