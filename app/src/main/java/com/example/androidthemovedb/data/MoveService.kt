package com.example.androidthemovedb.data

import com.example.androidthemovedb.models.detals.TheMoveDB
import com.example.androidthemovedb.models.forList.MoveForList
import com.example.androidthemovedb.utils.Constant.Companion.API_KEY
import com.example.androidthemovedb.utils.Constant.Companion.HEADER
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import java.sql.Date

interface MoveService {
    @GET("/3/movie/changes")
    suspend fun getMoveList(
        @Query("end_date") endDate: String = "",
        @Query("page") page: Int = 1,
        @Query("start_date") startDate: String = "",
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<MoveForList>

    @GET("/3/movie/{movie_id}?language=en-US")
    suspend fun getDetailsMove(
        @Path("movie_id") movieId: Int,
        @Query("append_to_response") appendToResponse: String = "",
        @Query("start_date") language: String = "en-US",
    ): Response<TheMoveDB>
}