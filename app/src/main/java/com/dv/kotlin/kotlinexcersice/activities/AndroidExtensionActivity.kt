package com.dv.kotlin.kotlinexcersice.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.dv.kotlin.kotlinexcersice.R
import com.dv.kotlin.kotlinexcersice.others.ToolbarActivity
import kotlinx.android.synthetic.main.andext_layout.*

class AndroidExtensionActivity: ToolbarActivity(){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView( R.layout.andext_layout)

        toolbarToLoad( toolbar as Toolbar )

        //Single way
        val btn1 = findViewById<Button>( R.id.btnById )
        btn1.setOnClickListener {
            Toast.makeText( this, "Click By ID", Toast.LENGTH_LONG ).show()
        }

        btnByKAT.setOnClickListener {
            Toast.makeText( this, "Click By KAT", Toast.LENGTH_LONG ).show()
        }
    }
}