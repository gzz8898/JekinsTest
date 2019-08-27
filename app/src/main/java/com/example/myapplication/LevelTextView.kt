package com.example.myapplication

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LevelListDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class LevelTextView : RelativeLayout {

    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private val layerList = LevelListDrawable()
    private var colors: Array<Int>? = null
    private var cornerRadius = 5f
    private var strokeColorsId = 0
    private var strokeWidth = 0
    private var textColors: Array<String>? = null
    private var titles: Array<String>? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, -1)
    constructor(context: Context, attributeSet: AttributeSet?, def: Int) : super(context, attributeSet, def) {
        val obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.LevelTextView)
        cornerRadius = obtainAttributes.getDimension(R.styleable.LevelTextView_ltv_corner, cornerRadius)
        strokeColorsId = obtainAttributes.getResourceId(R.styleable.LevelTextView_ltv_strokeColors, Color.WHITE)
        val strokeColors = context.resources.getStringArray(strokeColorsId)
        strokeWidth = obtainAttributes.getDimension(R.styleable.LevelTextView_ltv_strokeWidth, 0f).toInt()
        val textColorsId = obtainAttributes.getResourceId(R.styleable.LevelTextView_ltv_title_colors, 0)
        if (textColorsId != 0) {
            textColors = context.resources.getStringArray(textColorsId)
        }

        val titlesId = obtainAttributes.getResourceId(R.styleable.LevelTextView_ltv_titles, 0)
        if (titlesId != 0) {
            titles = context.resources.getStringArray(titlesId)
        }
        val backGroundColorId = obtainAttributes.getResourceId(R.styleable.LevelTextView_ltv_backGround_colors, 0)
        val backGroundColors = context.resources.getStringArray(backGroundColorId)
        obtainAttributes.recycle()
        for ((level, item) in backGroundColors.withIndex()) {
            getDrawable(Color.parseColor(item), Color.parseColor(strokeColors[level]), strokeWidth, cornerRadius, level)
        }
        init()
    }

    fun init() {
        imageView = ImageView(context)
        imageView.id = R.id.image_id
        imageView.setImageDrawable(layerList)
        val param = RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        param.addRule(ALIGN_TOP, R.id.tv_id)
        param.addRule(ALIGN_BOTTOM, R.id.tv_id)
        param.addRule(ALIGN_LEFT, R.id.tv_id)
        param.addRule(ALIGN_RIGHT, R.id.tv_id)
        addView(imageView, param)
        textView = TextView(context)
        textView.setPadding(10, 2, 10, 2)
        textView.text = "level"
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
        textView.setTextColor(Color.WHITE)
        textView.id = R.id.tv_id
        addView(textView)
    }

    private fun getDrawable(
        colorInt: Int,
        strokeColor: Int,
        strokeWidth: Int,
        cornerRadius: Float,
        level: Int
    ): Drawable {
        val drawable = GradientDrawable()
        drawable.setColor(colorInt)
        drawable.setStroke(strokeWidth, strokeColor)
        drawable.cornerRadius = cornerRadius
        layerList.addLevel(level, level, drawable)
        return drawable
    }



    fun setLevel(level: Int): LevelTextView {
        imageView.setImageLevel(level)
        titles?.let {
            textView.text = it[level]
            textColors?.let {
                textView.setTextColor(Color.parseColor(it[level]))

            }
        }
        return this
    }

    fun setLevelText(levelText: String): LevelTextView {
        textView.text = levelText
        return this
    }
}