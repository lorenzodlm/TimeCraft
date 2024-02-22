package com.example.timecraft.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.timecraft.R
import com.example.timecraft.databinding.FragmentAchievementBinding
import com.example.timecraft.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var binding: FragmentSettingsBinding? = null
    private val view get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        return view.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
