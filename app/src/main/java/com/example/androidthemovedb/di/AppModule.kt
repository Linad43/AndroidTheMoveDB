package com.example.androidthemovedb.di

import com.example.androidthemovedb.data.MoveService
import com.example.androidthemovedb.utils.Constant
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun baseUrl() = Constant.BASE_URL
    @Provides
    fun liggin() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun okHttpClient() = OkHttpClient.Builder()
        .addInterceptor(liggin())
        .build()
    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): MoveService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient())
            .build()
            .create(MoveService::class.java)
//    @Provides
//    @Singleton
//    fun provideRetrofit(): Request =
//        Request.Builder()
//            .url("https://api.themoviedb.org/3/movie/changes?page=1")
//            .get()
//            .addHeader("accept", "application/json")
//            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3OWE0MzY5MmYxMzQ0NzA2MDk5ZjFmMjM3ZDFlY2FkOSIsIm5iZiI6MTczMjk3NTMzNi45MTYsInN1YiI6IjY3NGIxYWU4ZjA0M2JjOGE2NzcxYWRhMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.fGd2q9hcckouJnEXZxQTMOtMF-pZE38iEpbeelN-CyU")
//            .build()
}