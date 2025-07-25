package com.example.lombatif.models.get

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DaftarUsersAdmin(
    @SerializedName("id") val id : String?,
    @SerializedName("nama") val nama : String?,
    @SerializedName("email") val email : String?,
    @SerializedName("role") val role : String?
) : Serializable
