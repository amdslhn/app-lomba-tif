package com.example.lombatif.models.get

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("id") val id: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("nama") val nama: String?,
    @SerializedName("role") val role: String?,
    @SerializedName("iat") val iat: String?
)

