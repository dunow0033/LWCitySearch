package com.express.android.lwcitysearch.network

import com.express.android.lwcitysearch.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    fun getDataFromAPI(@Query("q") query: String): Call<RecyclerList>
}