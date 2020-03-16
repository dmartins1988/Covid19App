package com.example.covid19app.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.ColorRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.covid19app.R
import kotlinx.android.synthetic.main.global_item_card_view.view.*

class GlobalCardView : CardView {

    constructor(context: Context) : super(context) {
        initView(context, null)
    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }


    private fun initView(context: Context?, attrs: AttributeSet?) {

        LayoutInflater.from(context).inflate(R.layout.global_item_card_view, this, true);

        val title: String?
        val subtitle: String?
        val a =
            context!!.theme.obtainStyledAttributes(attrs, R.styleable.CustomCardView, 0, 0)

        try {
            title = a.getString(R.styleable.CustomCardView_customCardViewTitle)
            subtitle = a.getString(R.styleable.CustomCardView_customCardViewSubtitle)
        } finally {
            a.recycle()
        }

        if (title != null) {
            title_tv.text = title
        }

        if (subtitle != null) {
            subtitle_tv.text = subtitle
        }

    }


    fun setTitle(text: String) {
        title_tv.text = text
    }

    fun setSubtitle(text: String, @ColorRes color: Int) {
        subtitle_tv.text = text
        subtitle_tv.setTextColor(ContextCompat.getColor(context, color))
    }
}