package dev.ivan_belyaev.cinemasearchapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dev.ivan_belyaev.cinemasearchapp.databinding.ActivityMainBinding
import dev.ivan_belyaev.core.base.di.ViewModelFactory
import javax.inject.Inject

internal class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainActivityViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        /*setTheme(coreUiR.style.Theme_Liberty)*/
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

   /* override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        MainActivityComponent.init((newBase.applicationContext as App).getApplicationProvider())
            .inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        *//*viewModel.setNavigator(ApplicationNavigator(this, binding.root.id))*//*
    }

    override fun onPause() {
        super.onPause()
        viewModel.removeNavigator()
    }*/
}