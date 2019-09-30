package com.dv.kotlin.kotlinexcersice.models

import android.os.Parcel
import android.os.Parcelable

// Parcel es un contenedor para un mensaje
// Puede ser usado para enviar un objeto Serialzado
// a traves de Intent y mejora rendimiento que Serializer.
data class Student(
    var name: String,
    var lastName: String,
    var age: Int,
    var isDeveloper: Boolean = true
): Parcelable{
    constructor( parcel: Parcel ): this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel( parcel: Parcel, flags: Int){
        // Escribir los valores en el mismo orden del constructor.
        parcel.writeString( name )
        parcel.writeString( lastName )
        parcel.writeInt( age )
        parcel.writeByte( if (isDeveloper) 1 else 0 )
    }

    // Describe el tipo de contenido del objeto Parcelable
    // 0 siempre se usa, el otro valor es 1 o CONTENTS_FILE_DESCRIPTOR
    // Para tipos de objetos que implementan File Descriptors
    override fun describeContents() = 0

    companion object CREATOR: Parcelable.Creator<Student>{

        // Esto creara el objeto desde el parcel llamando al constructor SECUNDARIO.
        override fun createFromParcel( parcel: Parcel ): Student = Student( parcel )

        // Ayuda a serializar arrays de objetos del mismo tipo de la clase.
        override fun newArray( size: Int ): Array<Student?> = arrayOfNulls<Student?>( size )
    }
}


