package com.carlosandrade.moviebus.view.custom

import android.content.Context
import android.util.AttributeSet
import androidx.cardview.widget.CardView
import com.carlosandrade.moviebus.R

class MovieItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.movie_item_view, this)
    }
}