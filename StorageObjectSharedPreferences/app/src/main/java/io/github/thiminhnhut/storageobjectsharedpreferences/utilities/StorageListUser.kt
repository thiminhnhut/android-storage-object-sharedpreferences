package io.github.thiminhnhut.storageobjectsharedpreferences.utilities

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import io.github.thiminhnhut.storageobjectsharedpreferences.model.ListUser
import io.github.thiminhnhut.storageobjectsharedpreferences.model.User

class StorageListUser {

    companion object {
        private const val sharedPreferencesFile = "sharePref"
        private const val keyListUser = "listUser"
        private lateinit var mPrefs: SharedPreferences
        fun newInstance(context: Context) : StorageListUser {
            mPrefs = context.getSharedPreferences(sharedPreferencesFile, Context.MODE_PRIVATE)
            return StorageListUser()
        }
    }

    fun put(listUser: ListUser) {
        val editor = mPrefs.edit()
        val gson = Gson()
        val json = gson.toJson(listUser)
        editor.putString(keyListUser, json)
        editor.apply()
    }

    fun get(): ArrayList<User> {
        val gson = Gson()
        val json = mPrefs.getString(keyListUser, null)
        return (gson.fromJson(json, ListUser::class.java) as ListUser).users
    }

}