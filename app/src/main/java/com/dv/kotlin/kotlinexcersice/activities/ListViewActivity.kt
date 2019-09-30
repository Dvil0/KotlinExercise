package com.dv.kotlin.kotlinexcersice.activities

import com.dv.kotlin.kotlinexcersice.models.Person
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.dv.kotlin.kotlinexcersice.R
import com.dv.kotlin.kotlinexcersice.adapters.PersonAdapter
import com.dv.kotlin.kotlinexcersice.others.ToolbarActivity
import kotlinx.android.synthetic.main.listview_layout.*

class ListViewActivity: ToolbarActivity(){

    private lateinit var adapter: PersonAdapter
    private lateinit var personList: List<Person>

    override fun onCreate( savedInstanceState: Bundle?){
        super.onCreate( savedInstanceState )
        setContentView( R.layout.listview_layout )

        toolbarToLoad( toolbar as Toolbar )

        personList = getPersons()
        adapter = PersonAdapter( this, personList )
        listView.adapter = adapter
    }

    private fun getPersons(): List<Person>{
        return listOf(
            Person( "Daniel", "Villamarin", 25 ),
            Person( "Anyi", "Chamorro", 23 ),
            Person( "Claudia", "Villamarin", 42 ),
            Person( "Andres", "Astaiza", 39 )
        )
    }
}