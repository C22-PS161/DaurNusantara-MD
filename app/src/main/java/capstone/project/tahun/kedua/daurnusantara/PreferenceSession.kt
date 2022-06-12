package capstone.project.tahun.kedua.daurnusantara

import android.content.Context
import android.util.Log

class PreferenceSession (context: Context) {

    companion object {
        private const val LOGIN_PREF = "login_pref"
        private const val EMAIL = "email"
        private const val PASSWORD = "password"
    }

    private val preference = context.getSharedPreferences(LOGIN_PREF, Context.MODE_PRIVATE)

    fun sesiSet(loginSession: LoginSession) {
        val prefses = preference.edit()
        prefses.putString(EMAIL, loginSession.email)
        prefses.putString(PASSWORD, loginSession.password)
        prefses.apply()
    }

    fun sesiGet(): LoginSession {
        val loginSession = LoginSession()
        loginSession.email = preference.getString(EMAIL, "")
        loginSession.password = preference.getString(PASSWORD, "")
        return  loginSession
    }

    fun sesiDelete() {
        val prefses = preference.edit()
        prefses.clear().apply()
    }
}