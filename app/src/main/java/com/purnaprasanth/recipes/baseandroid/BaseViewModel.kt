package com.purnaprasanth.recipes.baseandroid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.purnaprasanth.recipes.base.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import java.util.concurrent.CancellationException
import kotlin.coroutines.CoroutineContext

/**
 * Created by Purna on 2019-09-16 as a part of Recipes
 **/

/**
 * Base Class for ViewModel
 *
 * This also extends [CoroutineScope], hence acts as a parent for all the coRoutines started in this activity scope or Lifecycle
 *
 * @property parentJob parent job for the coRoutines started in this scope
 */

open class BaseViewModel(application: Application, protected val dispatchers: Dispatchers) :
    AndroidViewModel(application), CoroutineScope {
    private val parentJob = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = parentJob + dispatchers.ioDispatcher

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel(CancellationException("Parent Scope Destroyed"))
    }
}