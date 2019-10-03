package com.dv.kotlin.kotlinexcersice.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.dv.kotlin.kotlinexcersice.R
import com.dv.kotlin.kotlinexcersice.others.ToolbarActivity
import kotlinx.android.synthetic.main.permission_layout.*

class PermissionActivity: ToolbarActivity() {

    private val permissionCamera = 100


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.permission_layout)

        toolbarToLoad(toolbar as Toolbar)

//        btnPhoto.setOnClickListener { getPictureFromCameraAskingPermissions() }
        btnPhoto.setOnClickListener { getPictureFromCamera() }
    }

    // Tomar foto sin permiso
    private fun getPictureFromCamera(){
        // Solo funciona con el activity de la camara.
        // Asegurarse de que no hay permiso de camara en el manifest.
        // Crear intent para capturar la foto
        val pictureIntent = Intent( MediaStore.ACTION_IMAGE_CAPTURE )
        // Comprobar que podemos manejar la captura de fotos ( Camara y App de Camara)
        if( pictureIntent.resolveActivity( packageManager ) != null ){
        startActivityForResult( pictureIntent, permissionCamera )
        } else {
            // No hay activity que soporte el intent. (Por ejemplo sin camara)
        }
    }

    private fun getPictureFromCameraAskingPermissions() {
        // Adicionar Permiso al manifestma
        // Comprobar el permiso de la camara
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //Si no ha sido aceptado previamente (Para versiones desde la 6.0 [API 23] en adelante)
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                permissionCamera
            )
        } else {
            // Si ha sido aceptado previamente o ( Versiones inferiores a 6.0 [API 23])
            val intent = Intent( MediaStore.ACTION_IMAGE_CAPTURE )
            startActivityForResult( intent, permissionCamera )
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when( requestCode ){
            permissionCamera -> {
                if( grantResults.size == 1 && grantResults[ 0 ] == PackageManager.PERMISSION_GRANTED ){
                    // Permiso aceptado
                    val intent = Intent( MediaStore.ACTION_IMAGE_CAPTURE )
                    startActivityForResult( intent, permissionCamera )
                } else {
                    // Permiso ha sido denegado
                    Toast.makeText( this, "You can't take a picture if you don't allow it", Toast.LENGTH_LONG ).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when( requestCode ){
            permissionCamera -> {
                // Comprobar si el resultado es bueno
                if( resultCode == Activity.RESULT_OK ){
                    // Se obtiene los extras del intent recibido.
                    val extras = data!!.extras
                    // Ordenar el bitmap a partir de los extras
                    val imageBitMap = extras!!.get( "data" ) as Bitmap
                    // Cargar la foto como Bitmap en el imageView
                    imgViewPhoto.setImageBitmap( imageBitMap )
                } else {
                    // La foto no fue tomada con exito
                    Toast.makeText( this, "Picture has failed", Toast.LENGTH_LONG ).show()
                }
            }
        }
    }

}