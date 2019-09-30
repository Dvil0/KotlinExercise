package com.dv.kotlin.kotlinexcersice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.dv.kotlin.kotlinexcersice.R
import com.dv.kotlin.kotlinexcersice.models.Person
import kotlinx.android.synthetic.main.listview_person.view.*

class PersonAdapter( val context: Context, val list: List<Person>): BaseAdapter(){

    private val mInflator : LayoutInflater = LayoutInflater.from( context )

    override fun getItem( position: Int ): Any{
        return list[ position ]

    }

    override fun getItemId( position: Int ): Long{
        return position.toLong()
    }

    override fun getCount(): Int{
        return list.size
    }

    override fun getView( position: Int, convertView: View?, parentGroup: ViewGroup? ): View{
        val view: View
        val viewHolder: PersonViewHolder

        if( convertView == null ){

            view = mInflator.inflate( R.layout.listview_person, parentGroup, false )
            viewHolder = PersonViewHolder( view )
            view.tag = viewHolder

        } else {
            view = convertView
            viewHolder = view.tag as PersonViewHolder
        }

        val fullName = "${list[ position ].firstName}, ${list[ position ].lastName} "
        viewHolder.fullName.text = fullName
        viewHolder.age.text = list[ position ].age.toString()

        return view
    }
}

private class PersonViewHolder( view: View ){
    val fullName: TextView = view.txtName
    val age: TextView = view.txtAge
}