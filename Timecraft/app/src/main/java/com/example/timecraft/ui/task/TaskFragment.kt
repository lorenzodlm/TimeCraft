package com.example.timecraft.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.timecraft.databinding.FragmentTaskBinding
import com.example.timecraft.ui.task.Adapter.EventAdapter
import com.example.timecraft.ui.task.Adapter.ToDoAdapter

class TaskFragment : Fragment() {

    private val view: FragmentTaskBinding by lazy { FragmentTaskBinding.inflate(layoutInflater) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return view.root
    }

    override fun onViewCreated(binding: View, savedInstanceState: Bundle?) {
        super.onViewCreated(binding, savedInstanceState)

        view.fab.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val existingFragment = fragmentManager.findFragmentByTag(AddNewTask.TAG)
            if (existingFragment == null) {
                val newTaskFragment = AddNewTask()
                newTaskFragment.show(fragmentManager, AddNewTask.TAG)
            }
        }

    }

}