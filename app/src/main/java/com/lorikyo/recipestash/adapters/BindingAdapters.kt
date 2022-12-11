package com.lorikyo.recipestash.adapters

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import com.lorikyo.recipestash.R
import com.lorikyo.recipestash.models.MealDto
import org.w3c.dom.Text

@BindingAdapter("imageUrl")
fun bindImageFromUrl(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri) {
//            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_baseline_broken_image_24)
        }
    }

}

@BindingAdapter("inflateData")
fun bindIngredients(linearLayout: LinearLayout, mealDto: MealDto?) {
    mealDto?.let {
        linearLayout.removeViews(1, linearLayout.childCount - 1)
        val inflater: LayoutInflater = LayoutInflater.from(linearLayout.context)
        if(!mealDto.strIngredient1.isNullOrEmpty()) {
            val view = inflater.inflate(R.layout.ingredient, linearLayout, true)
            val textView = view.findViewById<TextView>(R.id.ingredient)
            textView.text = mealDto.strIngredient1
        }
    }
}