package com.example.myapplication

import android.content.Context
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout

class CustomerRatingView : LinearLayout {
    @DrawableRes
    private var defaultIconId = 0
    @DrawableRes
    private var ratingIconId = 0
    private var maxRatingNum = 5
    private var minRatingNum = 1
    private var inner_space = 5f
    private var defaultRatingNum = 0
    private var enableRating = false

    private val listImage = ArrayList<ImageView>()
    private var ratingNum = 0
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributes: AttributeSet?) : this(context, attributes, -1)
    constructor(context: Context, attributes: AttributeSet?, def: Int) : super(context, attributes, def) {
        val attr = context.obtainStyledAttributes(attributes, R.styleable.CustomerRatingView)
        enableRating = attr.getBoolean(R.styleable.CustomerRatingView_enable_rating, false)
        defaultIconId = attr.getResourceId(R.styleable.CustomerRatingView_default_icon, 0)
        ratingIconId = attr.getResourceId(R.styleable.CustomerRatingView_rating_icon, 0)
        defaultRatingNum = attr.getInt(R.styleable.CustomerRatingView_default_rating_num, 0)
        minRatingNum = attr.getInteger(R.styleable.CustomerRatingView_min_rating_num, 1)
        maxRatingNum = attr.getInteger(R.styleable.CustomerRatingView_max_rating_num, 5)
        inner_space = attr.getDimension(R.styleable.CustomerRatingView_inner_space, 5f)
        attr.recycle()
        initLayout()
    }

    /**
     *初始化
     */
    private fun initLayout() {
        listImage.clear()
        for (i in 1..maxRatingNum) {
            val param = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            val image = ImageView(context)
            if (defaultRatingNum >= i) {
                image.setImageResource(ratingIconId)
            } else {
                image.setImageResource(defaultIconId)
            }
            if (enableRating) {
                image.setOnClickListener {
                    ratingNum = i
                    for (curent in 1..maxRatingNum) {
                        if (curent <= i) {
                            listImage[curent - 1].setImageResource(ratingIconId)
                        } else {
                            listImage[curent - 1].setImageResource(defaultIconId)
                        }
                    }
                }
            }
            image.isEnabled = enableRating
            if (i == maxRatingNum) {
                inner_space = 0f
            }
            image.setPadding(0, 0, inner_space.toInt(), 0)
            addView(image, param)
            listImage.add(image)
        }

    }

    fun getRatingNum(): Int {
        return ratingNum
    }

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
    }

}