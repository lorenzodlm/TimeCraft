package com.example.timecraft.ui.profile

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import com.example.timecraft.R

import com.example.timecraft.ui.profile.placeholder.PlaceholderContent.PlaceholderItem
import com.example.timecraft.databinding.FragmentAchievementsBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyachievementsRecyclerViewAdapter(
    private val values: List<PlaceholderItem>) {

    inner class ViewHolder(binding: FragmentAchievementsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val achievementRV = binding.achievementsRV

    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentAchievementsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

}





