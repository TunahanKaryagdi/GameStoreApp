package com.tunahankaryagdi.gamestoreapp.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.Coil
import coil.load

@BindingAdapter("imageUrl")
fun  ImageView.loadUrl(url : String){
    this.load(url)
}