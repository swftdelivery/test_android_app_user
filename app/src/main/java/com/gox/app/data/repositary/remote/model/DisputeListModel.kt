package com.gox.app.data.repositary.remote.model

import java.io.Serializable

data class DisputeListModel(
        val error: List<Any>,
        val message: String,
        val responseData: List<DisputeListData>,
        val statusCode: String,
        val title: String
) : Serializable

data class DisputeListData(
        val id: String,
        val dispute_name: String
) : Serializable
