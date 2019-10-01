package com.dv.kotlin.kotlinexcersice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.dv.kotlin.kotlinexcersice.activities.*
import com.dv.kotlin.kotlinexcersice.others.ToolbarActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarToLoad( toolbar as Toolbar )

        val btnLifeCycle = findViewById<Button>(R.id.btnCycle)
        val btnClick = findViewById<Button>(R.id.btnClick)
        val btnAndroidExt = findViewById<Button>(R.id.btnAndExtensions)
        val btnPicasso = findViewById<Button>(R.id.btnPicasso)
        val btnList = findViewById<Button>(R.id.btnListView)
        val btnIntents = findViewById<Button>(R.id.btnIntents)
        val btnPermission = findViewById<Button>(R.id.btnPermission)
        val btnShared = findViewById<Button>(R.id.btnSharedPreferences)
        val btnExtFunctions = findViewById<Button>(R.id.btnExtensionFunctions)

        btnLifeCycle.setOnClickListener{
            goToLifeCycleActivity()
        }

        btnClick.setOnClickListener{
            goToClickEventActivity()
        }

        btnAndroidExt.setOnClickListener{
            goToAndroidExtensionsActivity()
        }

        btnPicasso.setOnClickListener{
            goToPicassoActivity()
        }

        btnList.setOnClickListener{
            goToListViewActivity()
        }

        btnIntents.setOnClickListener{
            goToIntentsActivity()
        }

        btnPermission.setOnClickListener{
            goToPermissionActivity()
        }

        btnShared.setOnClickListener{
            goToSharedPreferenceActivity()
        }

        btnExtFunctions.setOnClickListener{
            goToExtensionFunctionActivity()
        }
    }

    fun showToast(){
        Toast.makeText(this, "Hello from the Toast!", Toast.LENGTH_LONG).show()
    }

    fun showSnakcbar(){

        val layout = findViewById<ConstraintLayout>(R.id.constraint)
        Snackbar.make(layout,"Hello from the SnackBar!",Snackbar.LENGTH_LONG).show()
        Snackbar.make(layout, "Hellow from Kotlin", Snackbar.LENGTH_LONG).setAction("Undo"){
            Snackbar.make(layout, "Se ha restaurado satisfactoriamente.", Snackbar.LENGTH_LONG).show()
        }.show()
    }

    private fun goToLifeCycleActivity(){
        val intent = Intent( this, LifeCycleActivity::class.java)
        startActivity( intent )
    }

    private fun goToClickEventActivity(){
        val intent = Intent( this, ClickEventActivity::class.java)
        startActivity( intent )
    }

    private fun goToAndroidExtensionsActivity(){
        val intent = Intent( this, AndroidExtensionActivity::class.java)
        startActivity( intent )
    }

    private fun goToPicassoActivity(){
        val intent = Intent( this, PicassoActivity::class.java)
        startActivity( intent )
    }

    private fun goToListViewActivity(){
        val intent = Intent( this, ListViewActivity::class.java)
        startActivity( intent )
    }

    private fun goToIntentsActivity(){
        val intent = Intent( this, IntentsActivity::class.java)
        startActivity( intent )
    }

    private fun goToPermissionActivity(){
        val intent = Intent( this, PermissionActivity::class.java )
        startActivity( intent )
    }

    private fun goToSharedPreferenceActivity(){
        val intent = Intent( this, SharedPreferenceActivity::class.java )
        startActivity( intent )
    }

    private fun goToExtensionFunctionActivity(){
        val intent = Intent( this, ExtensionFunctionActivity::class.java )
        startActivity( intent )
    }

}
