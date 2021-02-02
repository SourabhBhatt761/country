package com.srb.countries.Adapter

import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso
import com.srb.countries.MainActivity
import com.srb.countries.R
import com.srb.countries.api.Language
import com.srb.countries.api.countryItem
import com.srb.countries.api.newsItem


class CountryAdapter(val context : Context, val daily : List<countryItem>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = daily[position]

        if(position % 2 == 0){
            holder.card.setCardBackgroundColor( ContextCompat.getColor(
                context,
                R.color.off
            ))
        }else
        {
            holder.card.setCardBackgroundColor( ContextCompat.getColor(
                context,
                R.color.gray
            ))
        }

        holder.borders.text = country.borders.toString()
        holder.capital.text = country.capital
        holder.name.text = country.name
        holder.population.text = country.population.toString()
        holder.region.text = country.region
        holder.subRegion.text = country.subregion
       holder.languages.text = country.languages[0].name


        val requestBuilder: RequestBuilder<PictureDrawable> = GlideToVectorYou
                .init()
                .with(context)
                .requestBuilder

        requestBuilder
                .load(country.flag)
                .into(holder.flag)

    }

    override fun getItemCount(): Int {
        return  daily.size
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        var flag = itemView.findViewById<ImageView>(R.id.IvFlag)
        var name = itemView.findViewById<TextView>(R.id.name)
        var capital = itemView.findViewById<TextView>(R.id.capital)
        var region = itemView.findViewById<TextView>(R.id.region)
        var subRegion = itemView.findViewById<TextView>(R.id.subregion)
        var population = itemView.findViewById<TextView>(R.id.population)
        var borders = itemView.findViewById<TextView>(R.id.borders)
        var languages = itemView.findViewById<TextView>(R.id.languages)
        var card = itemView.findViewById<CardView>(R.id.cardView)

    }
}