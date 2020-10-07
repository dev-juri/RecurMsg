package com.oluwafemi.recurmsg.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oluwafemi.recurmsg.R
import com.oluwafemi.recurmsg.databinding.MessageListBinding
import com.oluwafemi.recurmsg.model.MessageProperty

class MessageAdapter :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    var messages: List<MessageProperty> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class MessageViewHolder(val binding: MessageListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.message_list
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val withBinding: MessageListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            MessageViewHolder.LAYOUT,
            parent,
            false
        )
        return MessageViewHolder(withBinding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.binding.also {
            it.messageProp = messages[position]
        }
    }

    override fun getItemCount(): Int = messages.size
}