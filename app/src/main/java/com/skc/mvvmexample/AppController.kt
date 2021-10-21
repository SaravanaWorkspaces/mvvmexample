package com.skc.mvvmexample

import android.app.Application

/**

@author Saravana kumar Chinnaraj
@Date 20,October,2021
@company Obopay
@version 1.0
 */
class AppController : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: AppController? = null

        fun applicationContext() : AppController {
            return instance as AppController
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}