package com.abadil.convart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.abadil.convart.databinding.ActivityMainBinding
import com.abadil.convart.ui.FragmentConvert
import com.abadil.convart.ui.FragmentList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val convertFragment = FragmentConvert.newInstance("adil", "adil")
        val listFragment = FragmentList.newInstance("adil", "adil")

        setCurrentFragment(convertFragment)



        binding.bottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.bottom_nav_convert -> {
                    setCurrentFragment(convertFragment)
                    this.setTitle(R.string.app_name)
                    true
                }
                R.id.bottom_nav_list -> {
                    setCurrentFragment(listFragment)
                    true
                }
                else -> false
            }

        }


    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_frame_layout, fragment)
            commit()
        }
    }
}