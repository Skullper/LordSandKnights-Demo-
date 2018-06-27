package skullper.world.selector.utils

import org.jetbrains.anko.defaultSharedPreferences
import skullper.world.selector.extensions.appContext

/**
 * Created by pugman on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

object AppPreferences {

    private const val LOGIN = "pref.login"
    private const val PASSWORD = "pref.password"

    private val sPrefs = appContext.defaultSharedPreferences

    fun clear() {
        sPrefs.edit().clear().apply()
    }

    var login: String
        get() = sPrefs.getString(LOGIN, "")
        set(value) = sPrefs.edit().putString(LOGIN, value).apply()

    var password: String
        get() = sPrefs.getString(PASSWORD, "")
        set(value) = sPrefs.edit().putString(PASSWORD, value).apply()
}