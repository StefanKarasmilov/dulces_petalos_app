package com.example.dulcespetalosapp.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DulcesPetalosApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}