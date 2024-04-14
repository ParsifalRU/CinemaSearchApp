package dev.ivan_belyaev.core.wrapper

import android.content.SharedPreferences

interface SharedPreferencesWrapper {

    fun get(previousSearchList: List<String>): SharedPreferences?

    fun putValue(previousSearchList: List<String>, key: String, value: String)

    fun getValue(previousSearchList: List<String>, key: String, defaultValue: String): List<String>?
}