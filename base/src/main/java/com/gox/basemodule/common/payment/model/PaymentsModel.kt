package com.gox.basemodule.common.payment.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PaymentsModel {
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("status")
    @Expose
    private var status: String? = null
    @SerializedName("credentials")
    @Expose
    private var credentials: Credentials? = null

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String) {
        this.status = status
    }

    fun getCredentials(): Credentials? {
        return credentials
    }

    fun setCredentials(credentials: Credentials) {
        this.credentials = credentials
    }


}

class Credentials(
        val name: String,
        val value: String
) : Serializable
