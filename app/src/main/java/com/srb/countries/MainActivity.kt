package com.srb.countries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.srb.countries.Adapter.CountryAdapter
import com.srb.countries.api.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : CountryAdapter
   // private  val countries  = listOf( "Africa", "Americas", "Asia", "Europe", "Oceania")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       // val search = findViewById<AutoCompleteTextView>(R.id.Search)

        //val aAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries)
       // val final = search.setAdapter(aAdapter)

       // findViewById<ImageView>(R.id.ivSearch).setOnClickListener {
            getCountries()
        //}

    }

    private fun getCountries() {
        val recycle =findViewById<RecyclerView>(R.id.rvCountries)

        val countries = CountryService.countryInstance.getInformation(REGION)

        countries.enqueue(object : Callback<country?> {
            override fun onResponse(call: Call<country?>, response: Response<country?>) {
                val news = response.body()

                if (news != null){

                    Log.d("uni",news.toString())

                adapter = CountryAdapter(this@MainActivity,news as List<countryItem>)
                recycle.adapter  = adapter
                recycle.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<country?>, t: Throwable) {
                Log.d("uni","Error",t)
            }
        })

    }
}