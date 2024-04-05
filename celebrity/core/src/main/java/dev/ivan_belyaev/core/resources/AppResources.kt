package dev.ivan_belyaev.core.resources

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface AppResources {

    fun getString(@StringRes stringId: Int): String

    fun getString(@StringRes stringId: Int, vararg strings: String): String

    fun getStringByName(resourceName: String): String

    fun getStringByName(resourceName: String, @StringRes defaultStringRes: Int): String

    fun getStringByName(resourceName: String, defaultString: String): String

    @StringRes
    fun getStringResIdByName(resourceName: String, @StringRes defaultValue: Int = 0): Int

    fun getDrawable(@DrawableRes resId: Int): Drawable?

    fun getColor(@ColorRes resId: Int): Int

    fun getColorStateList(@ColorRes resId: Int): ColorStateList?
}