package com.example.wowzaexample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Data {

    @SerializedName("page")
    @Expose
     val page: Int? = null

    @SerializedName("per_page")
    @Expose
     val perPage: Int? = null

    @SerializedName("total")
    @Expose
     val total: Int? = null

    @SerializedName("total_pages")
    @Expose
     val totalPages: Int? = null

    @SerializedName("data")
    @Expose
     val user: ArrayList<User>? = null

}