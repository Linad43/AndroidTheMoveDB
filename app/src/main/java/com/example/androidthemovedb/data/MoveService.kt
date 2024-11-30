package com.example.androidthemovedb.data

import com.example.androidthemovedb.models.detals.TheMoveDB
import com.example.androidthemovedb.models.forList.MoveForList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.sql.Date

interface MoveService {
    @GET("https://api.themoviedb.org/3/movie/changes")
    suspend fun getMoveList(
        @Query("end_date") endDate: String = "",
        @Query("page") page: Int = 1,
        @Query("start_date") startDate: String = "",
    ): Response<MoveForList>

    @GET("https://api.themoviedb.org/3/movie/{movie_id}?language=en-US")
    suspend fun getDetailsMove(
        @Path("movie_id") movieId: Int,
        @Query("append_to_response") appendToResponse: String = "",
        @Query("start_date") language: String = "en-US",
    ): Response<TheMoveDB>
}