package com.oluwafemi.recurmsg.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.oluwafemi.recurmsg.adapter.MessageAdapter
import com.oluwafemi.recurmsg.model.MessageProperty

@BindingAdapter("messageBinding")
fun bindRecyclerViewData(recyclerView: RecyclerView, data : List<MessageProperty>?){
    val adapter = recyclerView.adapter as MessageAdapter
    adapter.submitList(data)
}