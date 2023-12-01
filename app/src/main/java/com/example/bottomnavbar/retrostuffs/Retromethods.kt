package com.example.bottomnavbar.retrostuffs

import retrofit2.http.GET

interface Retromethods {
@GET("db.json")
suspend fun getMovies():retrofit2.Response<movieclass>

}