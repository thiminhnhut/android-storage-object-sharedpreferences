package io.github.thiminhnhut.storageobjectsharedpreferences.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import io.github.thiminhnhut.storageobjectsharedpreferences.R

class FragmentAddUser : Fragment() {

    private lateinit var listener: OnEvent

    companion object {
        fun newInstance(listener: OnEvent): FragmentAddUser {
            val fragment = FragmentAddUser()
            fragment.listener = listener
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_add_user, container, false)

        val edtID = view.findViewById<EditText>(R.id.edtID)
        val edtName = view.findViewById<EditText>(R.id.edtName)
        val edtEmail = view.findViewById<EditText>(R.id.edtEmail)
        val btnAddUser = view.findViewById<Button>(R.id.btnAddUser)
        val btnShowUser = view.findViewById<Button>(R.id.btnShowUser)


        btnAddUser.setOnClickListener {
            listener.onClickAddUser(this,
                edtID.text.toString().toInt(),
                edtName.text.toString(),
                edtEmail.text.toString())
        }

        btnShowUser.setOnClickListener {
            listener.onClickShowUser(this)
        }

        return view
    }

    interface OnEvent {
        fun onClickAddUser(sender: Any, id: Int, name: String, email: String)
        fun onClickShowUser(sender: Any)
    }
}