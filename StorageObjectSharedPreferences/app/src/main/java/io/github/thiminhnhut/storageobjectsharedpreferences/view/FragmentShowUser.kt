package io.github.thiminhnhut.storageobjectsharedpreferences.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import io.github.thiminhnhut.storageobjectsharedpreferences.R
import io.github.thiminhnhut.storageobjectsharedpreferences.adapter.ListViewUserAdapter
import io.github.thiminhnhut.storageobjectsharedpreferences.model.User

class FragmentShowUser : Fragment() {

    companion object {
        private lateinit var listUser: ArrayList<User>
        fun newInstance(listUser: ArrayList<User>): FragmentShowUser {
            this.listUser = listUser
            return FragmentShowUser()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_show_user, container, false)
        val lvUser = view.findViewById<ListView>(R.id.lvUser)
        lvUser.adapter = ListViewUserAdapter(context!!, listUser)
        return view
    }
}