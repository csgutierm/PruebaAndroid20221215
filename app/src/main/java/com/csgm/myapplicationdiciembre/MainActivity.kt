package com.csgm.myapplicationdiciembre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val isLoggedIn = checkIfUserIsLoggedIn()

        if (isLoggedIn) {
            navigateToHome()
        } else {
            navigateToOnBoarding()
        }
    }

    private fun checkIfUserIsLoggedIn(): Boolean {

        return false
    }

    private fun navigateToOnBoarding() {
        val intent = Intent(this, OnBoardingActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}