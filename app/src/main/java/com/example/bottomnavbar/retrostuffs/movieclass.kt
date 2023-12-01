package com.example.bottomnavbar.retrostuffs

data class movieclass(
    val genres: List<String>,
    val movies: List<Movy>
) {
    data class Movy(
        val actors: String,
        val director: String,
        val genres: List<String>,
        val id: Int,
        val plot: String,
        val posterUrl: String,
        val runtime: String,
        val title: String,
        val year: String
    )
}