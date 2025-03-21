package com.example.managerapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppAdapter(private val context: Context, private val appList: List<AppInfo>) :
    RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    class AppViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewAppIcon: ImageView = itemView.findViewById(R.id.imageViewAppIcon)
        val textViewAppName: TextView = itemView.findViewById(R.id.textViewAppName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.app_item, parent, false)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val appInfo = appList[position]
        holder.textViewAppName.text = appInfo.appName
        holder.imageViewAppIcon.setImageDrawable(appInfo.appIcon)
    }

    override fun getItemCount(): Int {
        return appList.size
    }
}