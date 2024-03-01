package com.example.timecraft.ui.profile

data class Achievement(
    val achivementID: Int,
    val achievementImageID: Int, // Resource ID of the achievement image
    val achievementName: String,    // Name of the achievement
    val description: String // Description of the achievement
)