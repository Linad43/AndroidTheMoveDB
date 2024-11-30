package com.example.androidthemovedb.models.forList

data class MoveForList(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)