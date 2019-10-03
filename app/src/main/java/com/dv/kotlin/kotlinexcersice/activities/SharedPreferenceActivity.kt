package com.dv.kotlin.kotlinexcersice.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.dv.kotlin.kotlinexcersice.R
import com.dv.kotlin.kotlinexcersice.app.preferences
import com.dv.kotlin.kotlinexcersice.others.ToolbarActivity
import kotlinx.android.synthetic.main.shared_layout.*

class SharedPreferenceActivity: ToolbarActivity(){
    override fun onCreate( savedInstanceState: Bundle? ){
        super.onCreate( savedInstanceState )
        setContentView( R.layout.shared_layout )

        toolbarToLoad( toolbar as Toolbar )

        btnShared.setOnClickListener { setValuesSharedPreferences(); cleanEditText(); getValuesSharedPreferences();  }
        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences(){
        if( preferences.name.isNotEmpty() && preferences.age >= 0 ){
            txtResult.text = "Welcome ${preferences.name}, your age is ${preferences.age}"
        } else {
            txtResult.text = "Welcome. Please save your name and age"
        }
    }

    private fun setValuesSharedPreferences(){
        if( edtName.text.toString().isNotEmpty() && edtAge.text.toString().isNotEmpty()){
            preferences.name = edtName.text.toString()
            preferences.age = edtAge.text.toString().toInt()

            Toast.makeText( this, "Values have been saved successfully", Toast.LENGTH_LONG ).show()
        } else {
            Toast.makeText( this, "Please fill the name and age before saving", Toast.LENGTH_LONG ).show()
        }
    }

    private fun cleanEditText(){
        edtName.text.clear()
        edtAge.setText("")
        txtResult.setText("")
    }
}