package com.purnaprasanth.recipes.instances

import com.purnaprasanth.recipes.async.AppExecutor
import com.purnaprasanth.recipes.async.CommonExecutor
import com.purnaprasanth.recipes.async.IOExecutor
import com.purnaprasanth.recipes.async.MainThreadExecutor
import com.purnaprasanth.recipes.base.Dispatchers
import com.purnaprasanth.recipes.base.Executors
import com.purnaprasanth.recipes.base.creational.BaseGenerator
import com.purnaprasanth.recipes.base.creational.single
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * Container for [AppExecutor] or [Executors] or [Dispatchers] instances
 */

object ExecutorInstances {
    private val commonExecutorGenerator: BaseGenerator<AppExecutor> = single { CommonExecutor() }

    private val ioExecutorGenerator: BaseGenerator<AppExecutor> = single { IOExecutor() }

    private val mainExecutorGenerator: BaseGenerator<AppExecutor> = single { MainThreadExecutor() }

    private val appExecutorsProvider: BaseGenerator<Executors> = single {
        Executors(
            mainExecutor = mainExecutorGenerator.getInstance().executor,
            ioExecutor = ioExecutorGenerator.getInstance().executor,
            commonExecutor = commonExecutorGenerator.getInstance().executor
        )
    }

    private val appDispatchersProvider: BaseGenerator<Dispatchers> = single {
        Dispatchers(
            mainDispatcher = appExecutorsProvider.getInstance().mainExecutor.asCoroutineDispatcher(),
            ioDispatcher = appExecutorsProvider.getInstance().ioExecutor.asCoroutineDispatcher(),
            commonDispatcher = appExecutorsProvider.getInstance().commonExecutor.asCoroutineDispatcher()
        )
    }

    val appExecutors: Executors
        get() = appExecutorsProvider.getInstance()

    val appDispatchers: Dispatchers
        get() = appDispatchersProvider.getInstance()

    val mainDispatcher: CoroutineDispatcher
        get() = appDispatchers.mainDispatcher

    val ioDispatcher: CoroutineDispatcher
        get() = appDispatchers.ioDispatcher

    val commonDispatcher: CoroutineDispatcher
        get() = appDispatchers.commonDispatcher
}