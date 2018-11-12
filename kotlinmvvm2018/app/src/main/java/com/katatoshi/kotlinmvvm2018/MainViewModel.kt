package com.katatoshi.kotlinmvvm2018

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel {

    val executing = ObservableBoolean(false)

    val message = ObservableField("Hello Kotlin 1.3!")

    fun execute() {
        if (executing.get()) {
            return
        }

        GlobalScope.launch {
            executing.set(true)
            message.set("Please Wait...")
            delay(10_000)
            message.set("Hello Kotlin 1.3!")
            executing.set(false)
        }
    }
}