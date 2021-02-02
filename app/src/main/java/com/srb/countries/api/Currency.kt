package com.srb.countries.api


import com.google.gson.annotations.SerializedName

data class Currency(
    val code: String,
    val name: String,
    val symbol: String
)