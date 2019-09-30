package com.dv.kotlin.kotlinexcersice.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.dv.kotlin.kotlinexcersice.R
import com.dv.kotlin.kotlinexcersice.others.LifeCycleEventsActivity

class LifeCycleActivity: LifeCycleEventsActivity(){

    private var exitEnable = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView( R.layout.lifecycle_layout )
        //finish() - Destruye el Activity
    }

    override fun onBackPressed(){
        if( exitEnable == true ) {
            super.onBackPressed()
        }
        exitEnable = true
        Toast.makeText( this, "Click back again to exit this screen", Toast.LENGTH_LONG).show()
        Handler().postDelayed( Runnable { exitEnable = false }, 2000)
    }
}