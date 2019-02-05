package io.github.thiminhnhut.storageobjectsharedpreferences.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.github.thiminhnhut.storageobjectsharedpreferences.R

class FragmentActionBar : Fragment() {
    private lateinit var listener: OnEvent

    companion object {
        private lateinit var title: String
        private var isHideAction = false
        fun newInstance(listener: OnEvent, title: String, isHideAction: Boolean): FragmentActionBar {
            val fragment = FragmentActionBar()
            fragment.listener = listener
            this.title = title
            this.isHideAction = isHideAction
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_action_bar, container, false)

        val txtAction = view.findViewById<TextView>(R.id.txtAction)
        val txtTitle = view.findViewById<TextView>(R.id.txtTitle)

        txtTitle.text = title
        if (isHideAction) {
            txtAction.visibility = View.GONE
        } else {
            txtAction.setOnClickListener {
                listener.onClickBack(this)
            }
        }

        return view
    }

    interface OnEvent {
        fun onClickBack(sender: Any)
    }
}