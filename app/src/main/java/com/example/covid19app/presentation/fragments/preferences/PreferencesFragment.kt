package com.example.covid19app.presentation.fragments.preferences

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.covid19app.R
import com.example.covid19app.presentation.base.BaseFragment

class PreferencesFragment : BaseFragment() {

    companion object {
        fun newInstance() =
            PreferencesFragment()
    }

    private lateinit var viewModel: PreferencesViewModel

    override fun layoutId(): Int = R.layout.preferences_fragment

}
