package com.dv.kotlin.kotlinexcersice.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.dv.kotlin.kotlinexcersice.R
import com.dv.kotlin.kotlinexcersice.models.Student
import com.dv.kotlin.kotlinexcersice.others.ToolbarActivity
import kotlinx.android.synthetic.main.intent_extras_layout.*

class IntentExtrasActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intent_extras_layout)

        toolbarToLoad( toolbar as Toolbar )
        enableHomeDisplay( true )

        btnBack.setOnClickListener { startActivity( Intent( this, IntentsActivity::class.java )) }
         val isExtraSet = setIntentExtrasFromPreviusActivity()
        val isParcelableSet = setParcelableExtraFromPreviousActivity()

        if( !isExtraSet && !isParcelableSet ){
            chcDev.visibility = View.INVISIBLE
        }

    }

    private fun setParcelableExtraFromPreviousActivity(): Boolean{
        val student = intent.getParcelableExtra<Student>( "student" )
        student?.let{
            txtUno.text = student.name
            txtDos.text = student.lastName
            txtTres.text = student.age.toString()
            chcDev.isChecked = student.isDeveloper
            chcDev.text = "Developer"
            return true
        }
        return false
    }

    private fun setIntentExtrasFromPreviusActivity(): Boolean{
        val name: String? = intent.getStringExtra( "name" )
        val lastName: String? = intent.getStringExtra( "lastName" )
        val age: Int = intent.getIntExtra( "age", 0 )
        val developer = intent.getBooleanExtra( "developer", false )

        if( name != null && lastName != null && age >= 0 ) {
            txtUno.text = name
            txtDos.text = lastName
            txtTres.text = age.toString()
            chcDev.isChecked = developer
            chcDev.text = "Developer"
            return true
        }

        return false
    }

}
