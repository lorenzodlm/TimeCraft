package com.example.timecraft.ui.profile

data class Achievement(
    val id: Int,
    val imageID: Int, // Resource ID of the achievement image
    val name: String,    // Name of the achievement
    val description: String // Description of the achievement
)