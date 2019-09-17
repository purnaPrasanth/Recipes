package com.purnaprasanth.recipes.base.util

import java.util.concurrent.ThreadFactory

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

fun threadFactory(name: String, daemon: Boolean): ThreadFactory {
    return ThreadFactory { r ->
        val result = Thread(r, name)
        result.isDaemon = daemon
        result
    }
}