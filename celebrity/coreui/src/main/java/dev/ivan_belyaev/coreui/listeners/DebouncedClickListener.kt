package dev.ivan_belyaev.coreui.listeners

import android.os.SystemClock
import android.view.View

fun View.setDebouncedClickListener(
    delay: Long = 1500L,
    onClickAction: () -> Unit
){
    setOnClickListener(getDebouncedClickListener(delay, onClickAction ))
}

private fun getDebouncedClickListener(
    delay: Long,
    onClickAction: () -> Unit
): View.OnClickListener {
    return object : View.OnClickListener {

        var lastClickTime = 0L

        override fun onClick(v: View) {
            val currentTime = SystemClock.uptimeMillis()
            if (lastClickTime == 0L || currentTime - lastClickTime > delay) {
                lastClickTime = currentTime
                onClickAction()
            }
        }
    }
}