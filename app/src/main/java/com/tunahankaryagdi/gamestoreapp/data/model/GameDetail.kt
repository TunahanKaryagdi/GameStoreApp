package com.tunahankaryagdi.gamestoreapp.data.model

data class GameDetail(
    var id: Int,
    var title: String,
    var thumbnail: String,
    var status: String,
    var short_description: String,
    var description: String,
    var game_url: String,
    var genre: String,
    var platform: String,
    var publisher: String,
    var developer: String,
    var release_date: String,
    var freetogame_profile_url: String,
    var minimum_system_requirements: MinimumSystemRequirements,
    var screenshots: List<Screenshot>
)