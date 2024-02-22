package com.example.timecraft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.timecraft.databinding.ActivityMainBinding
import com.example.timecraft.ui.task.TaskFragment
import com.example.timecraft.ui.home.HomeFragment
import com.example.timecraft.ui.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val view: ActivityMainBinding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        val view: BottomNavigationView = findViewById(R.id.bottom_navigation)

        view.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.item_tasks -> changeFragment(TaskFragment())
                R.id.item_home -> changeFragment(HomeFragment())
                R.id.item_profile -> changeFragment(ProfileFragment())
                else -> false
            }
        }
    }

    private fun changeFragment(fragment: Fragment): Boolean {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(fragment::class.java.name)
            .commit()

        return true
    }
}