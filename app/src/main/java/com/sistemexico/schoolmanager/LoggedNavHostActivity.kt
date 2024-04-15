package com.sistemexico.schoolmanager

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.sistemexico.schoolmanager.databinding.ActivityNavHostLoggedBinding

class LoggedNavHostActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityNavHostLoggedBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)*/
        binding = ActivityNavHostLoggedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }


    private fun initUI() {
        initNavigation()
        initializers()
        listeners()
    }

    private fun initNavigation() {

        val navHost =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHost.navController
        binding.bottomNavView.setupWithNavController(navController)

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.chatFragment -> {
                    if (binding.bottomNavView.selectedItemId == R.id.profileFragment) {
                        val action = R.id.action_profileFragment_to_chatFragment
                        navController.navigate(action)
                    } else if (binding.bottomNavView.selectedItemId == R.id.payFragment) {
                        val action = R.id.action_payFragment_to_chatFragment
                        navController.navigate(action)
                    }

                    true
                }

                R.id.payFragment -> {
                    if (binding.bottomNavView.selectedItemId == R.id.profileFragment) {
                        val action = R.id.action_profileFragment_to_payFragment
                        navController.navigate(action)
                    } else if (binding.bottomNavView.selectedItemId == R.id.chatFragment) {
                        val action = R.id.action_chatFragment_to_payFragment
                        navController.navigate(action)
                    }

                    true
                }

                R.id.profileFragment -> {
                    if (binding.bottomNavView.selectedItemId == R.id.chatFragment) {
                        val action = R.id.action_chatFragment_to_profileFragment
                        navController.navigate(action)
                    } else if (binding.bottomNavView.selectedItemId == R.id.payFragment) {
                        val action = R.id.action_payFragment_to_profileFragment
                        navController.navigate(action)
                    }
                    true
                }
                // Agrega otros casos para cada elemento del BottomNavigationView
                else -> false
            }
        }

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val currentDestination = navController.currentDestination?.id
                if (currentDestination == R.id.profileFragment) {
                    // Si estamos en el fragmento de perfil, cierra la aplicación
                    finish()
                } else {
                    // Si no estamos en el fragmento de perfil, permite el comportamiento predeterminado del botón de retroceso
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val currentNightMode =
            resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
        val isNightMode = currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES
        when (item.itemId) {
            R.id.themeChange -> {
                AppCompatDelegate.setDefaultNightMode(if (isNightMode) AppCompatDelegate.MODE_NIGHT_NO else AppCompatDelegate.MODE_NIGHT_YES)
                recreate()
                return true
            }
        }
        return false;
    }


    private fun initializers() {
        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)
        val currentNightMode =
            resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
            true -> navView.menu.findItem(R.id.themeChange)
                .setIcon(ContextCompat.getDrawable(this, R.drawable.ic_dark))

            false -> navView.menu.findItem(R.id.themeChange)
                .setIcon(ContextCompat.getDrawable(this, R.drawable.ic_light))
        }
        navView.menu.findItem(R.id.themeChange).setChecked(true)

        val badge = binding.bottomNavView.getOrCreateBadge(R.id.chatFragment)
        badge.isVisible = true

    }

    private fun listeners() {
        binding.topBar.menu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

    }
}
