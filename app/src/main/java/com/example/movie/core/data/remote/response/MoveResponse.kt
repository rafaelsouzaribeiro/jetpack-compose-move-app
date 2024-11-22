package com.example.movie.core.data.remote.response

import com.example.movie.core.data.remote.model.MoveResult
import com.google.gson.annotations.SerializedName

data class MoveResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MoveResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)