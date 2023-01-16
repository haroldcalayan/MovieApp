package com.haroldcalayan.movieapp.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:src")
fun setImageDrawable(view: ImageView, resId: Int?) {
    resId?.let {
        view.setImageResource(it)
    }
}