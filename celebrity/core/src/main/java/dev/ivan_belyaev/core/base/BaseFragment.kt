package dev.ivan_belyaev.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import dev.ivan_belyaev.core.app.App
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.core.base.di.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(
    private val inflate: (
        LayoutInflater,
        ViewGroup?,
        Boolean
    ) -> VB,
    private val overrideBackButton: Boolean = false
) : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected abstract val viewModel: VM

    private var _binding: VB? = null
    val binding get() = requireNotNull(_binding) { "Binding not initialized" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject((requireActivity().application as App).getApplicationProvider())
        _binding = inflate.invoke(
            inflater,
            container,
            false
        )
        return binding.root
    }

    /**
     * Intended for initializing dagger component.
     */
    protected abstract fun inject(applicationProvider: ApplicationProvider)

/*    *//**
     * Observe flow with fragment's scope.
     *//*
    fun <T> Flow<T>.observe(action: suspend (T) -> Unit) {
        this.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach(action)
            .launchIn(lifecycleScope)
    }*/

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this, enabled = overrideBackButton) {
            onBackButtonPressed()
        }
    }

    /**
     * Called when system back button is pressed.
     *
     * Only works if [overrideBackButton] is set to true.
     */
    protected open fun onBackButtonPressed() = Unit
}