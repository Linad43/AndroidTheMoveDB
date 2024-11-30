package com.example.androidthemovedb.data


import java.sql.Date
import javax.inject.Inject

class MoveRepository @Inject constructor(
    private val moveService: MoveService
) {
    suspend fun getMoves(page:Int) =
        moveService.getMoveList(page = page)
}