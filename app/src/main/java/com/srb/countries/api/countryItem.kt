package com.srb.countries.api


import com.google.gson.annotations.SerializedName

data class countryItem(
    val area: Double,
    val borders: List<String>,
    val capital: String,
   // val currencies: List<Currency>,
    val flag: String,
    val languages: List<Language>,
    val name: String,
    val population: Int,
    val region: String,
    val subregion: String,
)