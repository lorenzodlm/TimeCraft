package com.example.timecraft.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.timecraft.R
import com.example.timecraft.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val achievementsButton: Button = binding.achievementsButton
        val settingsIcon: ImageView = binding.settingsIcon
        val completedTasksButton: Button = binding.completedTasksButton

        // Set click listeners
        achievementsButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_achievementsFragment)
        }

        settingsIcon.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_settingsFragment)
        }

        completedTasksButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_completedTasksFragment)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}