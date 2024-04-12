package dev.ivan_belyaev.coreui.listeners

import androidx.appcompat.widget.SearchView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun SearchView.setDebouncedQueryTextListener(
    delay: Long = 1000L,
    onQuerySubmitAction: (query: String?) -> Unit,
    onQueryChangeAction: (newText: String?) -> Unit
) {
    var debounceJob: Job? = null

    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            onQuerySubmitAction(query)
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            debounceJob?.cancel()
            debounceJob = CoroutineScope(Dispatchers.Main).launch {
                delay(delay)
                onQueryChangeAction(newText)
            }
            return true
        }
    })
}