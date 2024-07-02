package com.determent.ecombebop_management.android

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class Lamda(
    lamda: () -> Unit
) {

    suspend fun exampleAsync(): Job {
        return GlobalScope.async {
            // some work
        }
    }
}

object Lamda2 : (Int) -> Int {

    override fun invoke(p1: Int): Int {

    }

    fun backraud( contex: Co ): Lamda2 {
        return this
    }

    fun clip(): Lamda2 {
        return this
    }
    fun color(): Lamda2 {
        return this
    }
    fun with(): Lamda2 {
        return this
    }


}

