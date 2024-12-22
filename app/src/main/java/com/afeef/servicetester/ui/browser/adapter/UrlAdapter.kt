package com.afeef.servicetester.ui.browser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.afeef.servicetester.R
import com.afeef.servicetester.ui.browser.viewmodel.UrlStatus

class UrlAdapter(private val urls: List<UrlStatus>) : RecyclerView.Adapter<UrlAdapter.UrlViewHolder>() {

    class UrlViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val urlTextView: TextView = view.findViewById(R.id.url_text)
        val statusImageView: ImageView = view.findViewById(R.id.status_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrlViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_url, parent, false)
        return UrlViewHolder(view)
    }

    override fun onBindViewHolder(holder: UrlViewHolder, position: Int) {
        val urlStatus = urls[position]
        holder.urlTextView.text = urlStatus.url
        when (urlStatus.isReachable) {
            true -> holder.statusImageView.setImageResource(R.drawable.ic_check)
            false -> holder.statusImageView.setImageResource(R.drawable.ic_cross)
            else -> holder.statusImageView.setImageResource(R.drawable.ic_question)
        }
    }

    override fun getItemCount() = urls.size
}