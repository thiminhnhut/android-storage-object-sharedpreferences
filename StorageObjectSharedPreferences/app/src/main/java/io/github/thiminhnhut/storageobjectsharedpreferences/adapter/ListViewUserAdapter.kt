package io.github.thiminhnhut.storageobjectsharedpreferences.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import io.github.thiminhnhut.storageobjectsharedpreferences.R
import io.github.thiminhnhut.storageobjectsharedpreferences.model.User

class ListViewUserAdapter(private var context: Context, private var listUser: ArrayList<User>) : BaseAdapter() {
    override fun getView(position: Int, convertview: View?, viewGroup: ViewGroup?): View? {
        val view: View?
        val viewHolder: ViewHolder

        if (convertview == null) {
            val layoutInflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.row_listview_user, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertview
            viewHolder = convertview.tag as ViewHolder
        }

        viewHolder.txtID.text = listUser[position].id.toString()
        viewHolder.txtName.text = listUser[position].name
        viewHolder.txtEmail.text = listUser[position].email

        return view as View
    }

    override fun getItem(p0: Int): Any {
        return listUser[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return listUser.size
    }

    class ViewHolder (row: View) {
        val txtID = row.findViewById<TextView>(R.id.txtID)!!
        val txtName = row.findViewById<TextView>(R.id.txtName)
        val txtEmail = row.findViewById<TextView>(R.id.txtEmail)
    }


}