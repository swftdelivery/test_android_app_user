package com.gox.basemodule.common.payment.model

import com.google.gson.annotations.SerializedName

class ResCommonSuccessModel{
    @SerializedName("statusCode")
    var statusCode: String? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("message")
    var message: String? = null
}