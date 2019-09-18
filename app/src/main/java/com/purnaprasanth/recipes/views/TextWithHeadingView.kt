package com.purnaprasanth.recipes.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.MainThread
import androidx.databinding.DataBindingUtil
import com.purnaprasanth.recipes.R
import com.purnaprasanth.recipes.databinding.ViewTextWithHeadingBinding

/**
 * Created by Purna on 2019-09-18 as a part of Recipes
 **/
class TextWithHeadingView : LinearLayout {

    lateinit var binding: ViewTextWithHeadingBinding

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attributes: AttributeSet) : super(context, attributes) {
        initView()
    }

    constructor(context: Context, attributes: AttributeSet, defStyle: Int) : super(context, attributes, defStyle) {
        initView()
    }

    private fun initView() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflater, R.layout.view_text_with_heading, this, true)
    }

    @MainThread
    fun setTitle(title: String?) {
        binding.title.text = title
    }

    @MainThread
    fun setContent(content: String?) {
        binding.contentText.text = content
    }
}