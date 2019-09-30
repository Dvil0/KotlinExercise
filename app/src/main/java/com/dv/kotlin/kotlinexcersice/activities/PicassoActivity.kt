package com.dv.kotlin.kotlinexcersice.activities

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dv.kotlin.kotlinexcersice.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.picasso_layout.*
import java.lang.Exception

class PicassoActivity: AppCompatActivity(){

    override fun onCreate( savedInstanteState: Bundle?){
        super.onCreate( savedInstanteState )
        setContentView( R.layout.picasso_layout)

        btnLoader.setOnClickListener { loadImages() }
        Picasso.get().load("https://avvesione.files.wordpress.com/2015/06/fate_stay_night_unlimited_blade_works-24-shiro-trace_on-magic.jpg").fetch()

    }

    private fun loadImages(){
        Picasso.get()
            .load( "https://avvesione.files.wordpress.com/2015/06/fate_stay_night_unlimited_blade_works-24-shiro-trace_on-magic.jpg" )
            .placeholder( R.drawable.ic_mtrl_chip_close_circle )
            .error( R.drawable.ic_mtrl_chip_close_circle )
            .fit()
            .into( imgTop )

//        Picasso.get()
//            .load( "https://i.ytimg.com/vi/sgPPYLaUi-Y/maxresdefault.jpg" )
//            .placeholder( R.drawable.ic_mtrl_chip_close_circle )
//            .error( R.drawable.ic_mtrl_chip_close_circle )
//            .fit()
//            .into(imgBottom)

//        Picasso.get()
//            .load( "https://i.ytimg.com/vi/sgPPYLaUi-Y/maxresdefault.jpg" )
//            .placeholder( R.drawable.ic_mtrl_chip_close_circle )
//            .error( R.drawable.ic_mtrl_chip_close_circle )
//            .fit()
//            .transform( CircleTransform() ) //Renderizar la imagen como un circulo.
//            .into(imgBottom)

        val picasso = Picasso.get()

        picasso
            .load( "https://i.ytimg.com/vi/sgPPYLaUi-Y/maxresdefault.jpg" )
            .placeholder( R.drawable.ic_mtrl_chip_close_circle )
            .error( R.drawable.ic_mtrl_chip_close_circle )
            .fetch( object: Callback{
                override fun onSuccess() {
                    imgBottom.alpha = 0f
                    picasso
                        .load("https://i.ytimg.com/vi/sgPPYLaUi-Y/maxresdefault.jpg")
                        .placeholder( R.drawable.ic_mtrl_chip_close_circle )
                        .error( R.drawable.ic_mtrl_chip_close_circle )
                        .fit()
                        .into( imgBottom )

                    imgBottom.animate().setDuration( 300 ).alpha( 1f ).start()

                }

                override fun onError(e: Exception?) {

                }
            })
    }
}