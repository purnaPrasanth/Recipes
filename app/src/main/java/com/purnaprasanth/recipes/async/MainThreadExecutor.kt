package com.purnaprasanth.recipes.async

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * Executor for Main Thread Tasks
 */

@Singleton
class MainThreadExecutor : AppExecutor {
    override val executor: Executor
        get() = _executor

    private val _executor = object : Executor {
        override fun execute(runnable: Runnable?) {
            if (runnable == null) return
            MainHandler.INSTANCE.handler.post(runnable)
        }
    }
}

private class MainHandler private constructor() {

    val handler = Handler(Looper.getMainLooper())

    companion object {
        val INSTANCE: MainHandler by lazy { MainHandler() }
    }
}