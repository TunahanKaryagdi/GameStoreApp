package com.tunahankaryagdi.gamestoreapp.data.model


data class Game(
    var id : Int,
    var title : String,
    var thumbnail : String,
    var short_description : String,
    var game_url: String,
    var genre : String,
    var platform : String,
    var publisher : String,
    var release_date : String
)