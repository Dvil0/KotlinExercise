package com.dv.kotlin.kotlinexcersice.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.dv.kotlin.kotlinexcersice.R
import com.dv.kotlin.kotlinexcersice.others.ToolbarActivity
import kotlinx.android.synthetic.main.clickevent_layout.*

class ClickEventActivity: ToolbarActivity(), View.OnLongClickListener{

    // 1) Click en XML
    // 2) Click en linea
    // 3) Click by IDs en 'When'

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.clickevent_layout)

        toolbarToLoad( toolbar as Toolbar )

        val btn1 = findViewById<Button>( R.id.btnClickMulti1 )
        val btn2 = findViewById<Button>( R.id.btnClickMulti2 )
        val btn3 = findViewById<Button>( R.id.btnClickMulti3 )

        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)
    }

    fun xmlClick( view: View){
        Toast.makeText( this, "Click by XML", Toast.LENGTH_LONG).show()
    }

    private fun clickInLine(){
        val btn = findViewById<Button>( R.id.btnClickInline )
        btn.setOnClickListener { Toast.makeText( this, "Click by Inline", Toast.LENGTH_LONG).show() }
    }

    override fun onLongClick(view: View): Boolean {
        when( view.id ){
            R.id.btnClickMulti1 -> Toast.makeText( this, "Click Multi 1", Toast.LENGTH_LONG).show()
            R.id.btnClickMulti2 -> Toast.makeText( this, "Click Multi 2", Toast.LENGTH_LONG).show()
            R.id.btnClickMulti3 -> Toast.makeText( this, "Click Multi 3", Toast.LENGTH_LONG).show()
        }
        return true
    }
}