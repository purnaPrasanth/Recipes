package com.purnaprasanth.recipes.async

import com.purnaprasanth.recipes.base.util.threadFactory
import java.util.concurrent.Executor
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * Executor for IO Operational tasks
 */

@Singleton
class IOExecutor @Inject constructor() : AppExecutor {
    override val executor: Executor
        get() = _executor

    private val _executor = ThreadPoolExecutor(
        0,
        10,
        15,
        TimeUnit.SECONDS,
        SynchronousQueue<Runnable>(),
        threadFactory("App IO Executor", false)
    )
}