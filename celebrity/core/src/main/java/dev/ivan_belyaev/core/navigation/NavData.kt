package dev.ivan_belyaev.core.navigation

import android.os.Bundle
import androidx.annotation.IdRes

data class NavData(
    @IdRes val resId: Int,
    val args: Bundle? = null
)