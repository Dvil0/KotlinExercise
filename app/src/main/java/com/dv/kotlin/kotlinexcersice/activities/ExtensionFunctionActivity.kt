package com.dv.kotlin.kotlinexcersice.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dv.kotlin.kotlinexcersice.MainActivity
import com.dv.kotlin.kotlinexcersice.R
import com.dv.kotlin.kotlinexcersice.others.goToActivity
import com.dv.kotlin.kotlinexcersice.others.loadByUrl
import com.dv.kotlin.kotlinexcersice.others.snackBar
import com.dv.kotlin.kotlinexcersice.others.toast
import kotlinx.android.synthetic.main.extension_layout.*

class ExtensionFunctionActivity: AppCompatActivity(){

    override fun onCreate( savedInstanceState: Bundle? ){
        super.onCreate( savedInstanceState )
        setContentView( R.layout.extension_layout )

        btnToast.setOnClickListener{ toast( "Hello World" ) }
        btnSnackBar.setOnClickListener{ snackBar( "I love extension functions", action = "Undo" ){ toast( "Undo!" )} }
        btnLoadUrl.setOnClickListener{ imgViewExt.loadByUrl( "https://cdn2-www.gamerevolution.com/assets/uploads/2019/06/maxresdefault_1_640x360-1.jpg" ) }
        btnGoToActivity.setOnClickListener{ goToActivity<MainActivity>() }
    }
}