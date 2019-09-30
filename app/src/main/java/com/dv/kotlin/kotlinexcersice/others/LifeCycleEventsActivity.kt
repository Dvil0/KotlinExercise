package com.dv.kotlin.kotlinexcersice.others

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class LifeCycleEventsActivity: AppCompatActivity(){

    override fun onCreate( savedInstanceState: Bundle?){
        super.onCreate( savedInstanceState )

        Toast.makeText( this, "OnCreate", Toast.LENGTH_LONG).show()
    }

    override fun onStart(){
        super.onStart()

        Toast.makeText( this, "OnStart", Toast.LENGTH_LONG).show()
    }

    override fun onResume(){
        super.onResume()

        Toast.makeText( this, "OnResume", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText( this, "OnPause", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText( this, "OnStop", Toast.LENGTH_LONG).show()
    }


    override fun onRestart() {
        super.onRestart()

        Toast.makeText( this, "OnRestart", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText( this, "OnDestroy", Toast.LENGTH_LONG).show()
    }
}