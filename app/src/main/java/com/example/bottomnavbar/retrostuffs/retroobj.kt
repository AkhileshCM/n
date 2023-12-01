package com.example.bottomnavbar.retrostuffs

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retroobj {
    val baseurl="https://test.create.diagnal.com/data/"
    fun getinstance():Retrofit{
        return Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build()
    }
}