package com.purnaprasanth.recipes.async

import android.os.AsyncTask
import java.util.concurrent.Executor
import javax.inject.Singleton

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * Executor for Common Computational tasks
 */

@Singleton
class CommonExecutor : AppExecutor {
    override val executor: Executor
        get() = AsyncTask.THREAD_POOL_EXECUTOR
}