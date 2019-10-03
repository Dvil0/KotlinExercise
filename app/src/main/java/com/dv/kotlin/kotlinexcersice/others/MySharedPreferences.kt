package com.dv.kotlin.kotlinexcersice.others

import android.content.Context

class MySharedPreferences( context: Context ){

    // Nombre fichero shared preferences
    private val fileName = "myPreferences"

    // Instancia de ese fichero
    private val prefs = context.getSharedPreferences( fileName, Context.MODE_PRIVATE )

    // Por cada una de las variables que se guardan en el fichero
    var name: String
        get() = prefs.getString("name", "" )
        set( value ) = prefs.edit().putString( "name", value).apply()

    var age: Int
        get() = prefs.getInt("age", -1 )
        set( value ) = prefs.edit().putInt( "age", value).apply()
}