package com.gox.basemodule.model

import com.google.gson.annotations.SerializedName

class  CityDataModel{
    @SerializedName("id")
    var id: String? = null
    @SerializedName("city_name")
    var cityName: String? = null
}