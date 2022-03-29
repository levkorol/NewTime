package ru.harlion.newtime

import android.app.Application
import com.google.gson.Gson
import ru.harlion.newtime.data.Repository

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Repository.initialize(this)
    }

    companion object {
        val gson = Gson()
    }
}