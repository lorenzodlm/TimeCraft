package com.example.timecraft.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.timecraft.R
import com.example.timecraft.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private val view: FragmentProfileBinding by lazy { FragmentProfileBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return view.root
    }

    override fun onViewCreated(binding: View, savedInstanceState: Bundle?) {
        super.onViewCreated(binding, savedInstanceState)

        view.settingsBtn.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, SettingsFragment())
                .addToBackStack(SettingsFragment::class.java.name)
                .commit()
        }



    }

}