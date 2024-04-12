package dev.ivan_belyaev.core_impl.wrapperimpl

import android.content.Context
import android.content.SharedPreferences
import dev.ivan_belyaev.core.wrapper.SharedPreferencesWrapper
import javax.inject.Inject

class SharedPreferencesWrapperImpl
@Inject constructor(
    private val context: Context
) : SharedPreferencesWrapper {

    override fun get(previousSearchList: List<String>): SharedPreferences? {
        return context.getSharedPreferences(previousSearchList.toString(), Context.MODE_PRIVATE)
    }

    override fun putValue(previousSearchList: List<String>, key: String, value: String) {
        val sharedPreferences = get(previousSearchList)
        val editor = sharedPreferences?.edit()
        editor?.putString(key, value)
        editor?.apply()
    }

    override fun getValue(previousSearchList: List<String>, key: String, defaultValue: String): List<String>? {
        val sharedPreferences = get(previousSearchList)
        val savedString = sharedPreferences?.getString(key, defaultValue)
        return if (!savedString.isNullOrEmpty()) {
            savedString.split(",").map { it.trim() }
        } else emptyList()
    }
}