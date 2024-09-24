package com.codandotv.streamplayerapp.feature_list_streams.list.data.model

@Suppress("ConstructorParameterNaming")
data class StreamResponse(
    val id : String,
    val title : String,
    val overview : String,
    val poster_path: String? = null,
)
data class ListStreamResponse(
    val results: List<StreamResponse>
)