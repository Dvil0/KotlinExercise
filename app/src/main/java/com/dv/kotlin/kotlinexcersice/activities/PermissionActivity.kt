package com.dv.kotlin.kotlinexcersice.activities

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.dv.kotlin.kotlinexcersice.R
import com.dv.kotlin.kotlinexcersice.others.ToolbarActivity
import kotlinx.android.synthetic.main.permission_layout.*

class PermissionActivity: ToolbarActivity(){

    override fun onCreate( savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView( R.layout.permission_layout )

        toolbarToLoad( toolbar as Toolbar )
    }
}