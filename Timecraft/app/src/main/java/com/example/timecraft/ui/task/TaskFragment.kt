package com.example.timecraft.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.timecraft.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {

    private val view: FragmentTaskBinding by lazy { FragmentTaskBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return view.root
    }
}