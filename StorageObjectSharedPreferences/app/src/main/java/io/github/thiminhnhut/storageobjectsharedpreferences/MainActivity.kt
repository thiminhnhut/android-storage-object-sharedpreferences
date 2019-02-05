package io.github.thiminhnhut.storageobjectsharedpreferences

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.github.thiminhnhut.storageobjectsharedpreferences.model.ListUser
import io.github.thiminhnhut.storageobjectsharedpreferences.model.User
import io.github.thiminhnhut.storageobjectsharedpreferences.utilities.StorageListUser
import io.github.thiminhnhut.storageobjectsharedpreferences.view.FragmentActionBar
import io.github.thiminhnhut.storageobjectsharedpreferences.view.FragmentAddUser
import io.github.thiminhnhut.storageobjectsharedpreferences.view.FragmentShowUser

class MainActivity : AppCompatActivity() {

    private var listUser = arrayListOf<User>()

    private lateinit var storageListUser: StorageListUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        storageListUser = StorageListUser.newInstance(applicationContext)

        if (savedInstanceState == null) {
            screenAddUser()
        }
    }

    private fun screenAddUser() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_action_bar,
                FragmentActionBar.newInstance(object : FragmentActionBar.OnEvent {
                    override fun onClickBack(sender: Any) {

                    }
                }, "Add User", true))
            .replace(R.id.fragment_contents,
                FragmentAddUser.newInstance(object : FragmentAddUser.OnEvent {
                    override fun onClickAddUser(sender: Any, id: Int, name: String, email: String) {
                        listUser.add(User(id, name, email))
                        storageListUser.put(ListUser(listUser))
                    }

                    override fun onClickShowUser(sender: Any) {
                        screenShowUser()
                    }
                }))
            .commit()
    }

    private fun screenShowUser() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_action_bar,
                FragmentActionBar.newInstance(object : FragmentActionBar.OnEvent {
                    override fun onClickBack(sender: Any) {
                        screenAddUser()
                    }
                }, "List User", false))
            .replace(R.id.fragment_contents,
                FragmentShowUser.newInstance(storageListUser.get()))
            .commit()
    }
}
