package com.sistemexico.schoolmanager

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.sistemexico.schoolmanager.adapter.AdapterViewPagerLogged
import com.sistemexico.schoolmanager.databinding.ActivityLoggedBinding

class LoggedActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityLoggedBinding

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            when (position) {
                0 -> binding.bottomNavView.selectedItemId = R.id.chatFragment
                1 -> binding.bottomNavView.selectedItemId = R.id.profileFragment
                2 -> binding.bottomNavView.selectedItemId = R.id.payFragment
            }
            super.onPageSelected(position)
        }
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (binding.viewPager.currentItem != 1) {
                binding.viewPager.currentItem = 1
                isEnabled = true
            } else {
                finishAffinity()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)*/
        binding = ActivityLoggedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        initializers()
        viewPagerAdapter()
        viewPagerBottomNavUnion()
        viewPagerDefaultPage()
        listeners()
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

    private fun viewPagerDefaultPage() {
        binding.viewPager.currentItem = 1
    }

    private fun viewPagerBottomNavUnion() {
        binding.viewPager.registerOnPageChangeCallback(pageChangeCallback)
        /*
                binding.bottomNavView.setOnItemSelectedListener(bottomNavChangeCallback)
        */
    }

    private fun viewPagerAdapter() {
        binding.viewPager.adapter = AdapterViewPagerLogged(this)
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    private fun listeners() {

        binding.topBar.menu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.chatFragment -> {
                    binding.viewPager.currentItem = 0
                    true
                }

                R.id.profileFragment -> {
                    binding.viewPager.currentItem = 1
                    true
                }

                R.id.payFragment -> {
                    binding.viewPager.currentItem = 2
                    true
                }

                /* R.id.settings -> {
                     binding.drawerLayout.openDrawer(GravityCompat.START)
                     false
                 }*/

                else -> true
            }
        }
    }
}
