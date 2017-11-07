package com.example.pripachkin.kotlinproject

import android.app.Application
import android.database.sqlite.SQLiteOpenHelper
import com.example.pripachkin.kotlinproject.data.MyDatabaseHelper

/**
 * Created by Anton P. on 07.11.2017.
 */
class App : Application() {
    val database : SQLiteOpenHelper by lazy { MyDatabaseHelper(this) }

    companion object {
        var instance: App by NotNullSingleValueVar.DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        val db = database.writableDatabase
    }
}