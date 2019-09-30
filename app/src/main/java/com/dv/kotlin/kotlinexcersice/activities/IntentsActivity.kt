package com.dv.kotlin.kotlinexcersice.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.dv.kotlin.kotlinexcersice.R
import com.dv.kotlin.kotlinexcersice.models.Student
import com.dv.kotlin.kotlinexcersice.others.ToolbarActivity
import kotlinx.android.synthetic.main.intent_layout.*

class IntentsActivity: ToolbarActivity(){

    override fun onCreate( savedInstanceState: Bundle?){
        super.onCreate( savedInstanceState )
        setContentView( R.layout.intent_layout )

        toolbarToLoad( toolbar as Toolbar )

        btnExtras.setOnClickListener{
            goIntentsExtra()
        }

        btnFlags.setOnClickListener {
            goIntentFlag()
        }

        btnObject.setOnClickListener {
            goIntentObject()
        }

    }

    private fun goIntentsExtra(){
        val intent = Intent( this, IntentExtrasActivity::class.java )
        intent.putExtra( "name", "Daniel" )
        intent.putExtra( "lastName", "Villamarin" )
        intent.putExtra( "age", 25 )
        intent.putExtra( "developer", true )
        startActivity( intent )
    }

    private fun goIntentFlag(){
        val intent = Intent( this, IntentExtrasActivity::class.java )
//        intent.flags = Intent. //No guarda el activity en el backStack
//        intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION //No adiciona animacion al start.
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK //Elimina el stack completo.
        startActivity( intent )
//        finish() // Destruye el activity del contexto actual - No guarda en backStack
    }

    private fun goIntentObject(){
        val intent = Intent( this, IntentExtrasActivity::class.java )
        val student = Student( "Daniel", "Villamarin", 25, true)
        intent.putExtra( "student", student)
        startActivity( intent )
    }
}