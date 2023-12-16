package com.csgm.myapplicationdiciembre

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager


class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(Fragment1())
        adapter.addFragment(Fragment2())
        adapter.addFragment(Fragment3())
        viewPager.adapter = adapter

        val btnGetStarted: Button = findViewById(R.id.btnGetStarted)

        btnGetStarted.setOnClickListener {
            navigateToLogin()
        }

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {

                val pageCount = adapter.count
                //val newPosition = position % pageCount
                val newPosition = (position + pageCount) % pageCount

                //btnGetStarted.visibility = if (position == 0) View.VISIBLE else View.GONE
                btnGetStarted.visibility = if (newPosition == 0) View.VISIBLE else View.GONE

                //val currentFragment = adapter.getItem(position) as NumberedFragment
                //currentFragment.setNumber(position + 1)
            }
        })
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private val fragmentList: MutableList<Fragment> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment) {
            fragmentList.add(fragment)
        }
    }

/*    interface NumberedFragment {
        fun setNumber(number: Int)
    }*/
}
