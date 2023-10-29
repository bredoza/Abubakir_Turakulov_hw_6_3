package com.example.abubakir_turakulov_hw_6_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ObjectAdapter(private val objects: List<ObjectItem>) :
    RecyclerView.Adapter<ObjectAdapter.ObjectViewHolder>() {

    class ObjectViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarImageView: ImageView = itemView.findViewById(R.id.iv_avatar)
        val nameTextView: TextView = itemView.findViewById(R.id.tv_name)
        val messageTextView: TextView = itemView.findViewById(R.id.tv_text)
        val timeTextView: TextView = itemView.findViewById(R.id.tv_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_object, parent, false)
        return ObjectViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ObjectViewHolder, position: Int) {
        val currentItem = objects[position]
        Glide.with(holder.itemView)
            .load(currentItem.avatarUrl)
            .circleCrop()
            .into(holder.avatarImageView)

        holder.nameTextView.text = currentItem.name
        holder.messageTextView.text = currentItem.message
        holder.timeTextView.text = generateRandomTime()
    }


    private fun generateRandomTime(): CharSequence? {
        val hour = (0..23).random()
        val minute = (0..59).random()
        return String.format("%02d:%02d", hour, minute)
    }

    override fun getItemCount(): Int {
        return objects.size
    }
}