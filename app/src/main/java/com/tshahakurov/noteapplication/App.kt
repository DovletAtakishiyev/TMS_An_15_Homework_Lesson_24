package com.tshahakurov.noteapplication

import android.app.Application
import com.tshahakurov.noteapplication.db.MyDataBase

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MyDataBase.createDataBase(applicationContext)
    }
}