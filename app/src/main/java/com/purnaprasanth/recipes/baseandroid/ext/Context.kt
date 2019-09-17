package com.purnaprasanth.recipes.baseandroid.ext

import android.content.Context
import android.widget.Toast

/**
 * Created by Purna on 2019-09-17 as a part of Recipes
 **/

fun Context.showShortToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}