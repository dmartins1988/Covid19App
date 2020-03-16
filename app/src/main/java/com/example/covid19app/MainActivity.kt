package com.example.covid19app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.covid19app.presentation.fragments.countries.CountriesFragment
import com.example.covid19app.presentation.fragments.global.GlobalFragment
import com.example.covid19app.presentation.fragments.preferences.PreferencesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(GlobalFragment.newInstance())

        bottom_view.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.global_item -> {
                    loadFragment(GlobalFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.countries_item -> {
                    loadFragment(CountriesFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.preferences_item -> {
                    loadFragment(PreferencesFragment.newInstance())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
