package com.tunahankaryagdi.gamestoreapp.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group
import androidx.databinding.BindingAdapter
import coil.load
import com.tunahankaryagdi.gamestoreapp.data.model.MinimumSystemRequirements

@BindingAdapter("imageUrl")
fun ImageView.loadUrl(url: String? = null) {
    url?.let {
        this.load(url)
    }

}
