package dev.ivan_belyaev.core_impl.resources

import android.app.Application
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import dev.ivan_belyaev.core.resources.AppResources
import javax.inject.Inject

class AppResourcesImpl @Inject constructor(
    private val application : Application
) : AppResources {

    private val resources = application.resources

    override fun getString(@StringRes stringId: Int): String {
        return resources.getString(stringId)
    }
    override fun getString(@StringRes stringId: Int, vararg strings: String): String {
        return resources.getString(stringId, *strings)
    }

    override fun getStringByName(resourceName: String, @StringRes defaultStringRes: Int): String {
        val resId = getStringResIdByName(resourceName)
        return if (resId != 0) resources.getString(resId) else resources.getString(defaultStringRes)
    }

    override fun getStringByName(resourceName: String): String {
        return resources.getString(getStringResIdByName(resourceName))
    }

    override fun getStringByName(resourceName: String, defaultString: String): String {
        val resId = getStringResIdByName(resourceName)
        return if (resId != 0) resources.getString(resId) else defaultString
    }

    @StringRes
    override fun getStringResIdByName(resourceName: String, @StringRes defaultValue: Int): Int {
        return if (resourceName.isBlank()) {
            defaultValue
        } else {
            val resId = resources.getIdentifier(resourceName, "string", application.applicationContext.packageName)
            if (resId != 0) resId else defaultValue
        }
    }

    @RawRes
    fun getRawResIdByName(resourceName: String): Int {
        return resources.getIdentifier(resourceName, "raw", application.applicationContext.packageName)
    }

    override fun getDrawable(@DrawableRes resId: Int): Drawable? {
        return ContextCompat.getDrawable(application.applicationContext, resId)
    }

    override fun getColor(@ColorRes resId: Int): Int {
        return ContextCompat.getColor(application.applicationContext, resId)
    }

    override fun getColorStateList(@ColorRes resId: Int): ColorStateList? {
        return ContextCompat.getColorStateList(application.applicationContext, resId)
    }
}