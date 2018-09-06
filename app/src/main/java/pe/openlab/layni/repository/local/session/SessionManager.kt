package pe.openlab.layni.repository.local.session

import android.content.Context
import android.content.SharedPreferences

object SessionManager {

    private const val NAME = "LayniPreferences"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val IS_LOGGED = Pair("is_logged", false)

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var isLogged: Boolean
        get() = preferences.getBoolean(IS_LOGGED.first, IS_LOGGED.second)
        set(value) = preferences.edit { it.putBoolean(IS_LOGGED.first, value) }

}