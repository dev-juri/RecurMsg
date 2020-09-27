package com.oluwafemi.recurmsg.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.oluwafemi.recurmsg.databinding.MessageListBinding
import com.oluwafemi.recurmsg.model.MessageProperty

class MessageAdapter :
    ListAdapter<MessageProperty, MessageAdapter.MessageViewHolder>(DiffUtilCallback) {
    companion object DiffUtilCallback : DiffUtil.ItemCallback<MessageProperty>() {
        override fun areItemsTheSame(oldItem: MessageProperty, newItem: MessageProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MessageProperty, newItem: MessageProperty): Boolean {
            return oldItem.id == oldItem.id
        }
    }

    class MessageViewHolder(private val binding : MessageListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(messageProperty: MessageProperty) {
            binding.messageProp = messageProperty
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(MessageListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = getItem(position)
        holder.bind(message)
    }
}