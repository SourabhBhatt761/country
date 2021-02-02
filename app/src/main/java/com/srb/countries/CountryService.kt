package com.srb.countries

import android.telecom.Call
import com.srb.countries.api.country
import com.srb.countries.api.countryItem
import com.srb.countries.api.news
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://restcountries.eu/rest/v2/region/{region}
const val REGION = "Asia"
const val BASE_URL = "https://restcountries.eu/"


interface CountryInterface{

    @GET("rest/v2/")
    fun getInformation( @Query("region/")region : String ) : retrofit2.Call<country>

}

object CountryService{

    val countryInstance:CountryInterface

    init {
        val retrofit =Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    countryInstance = retrofit.create(CountryInterface::class.java)
    }
}