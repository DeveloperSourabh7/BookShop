package com.sourabh.bookshop.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.canerture.booksapp.ui.login.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.sourabh.bookshop.R
import com.sourabh.bookshop.common.Constants.SIGN_IN
import com.sourabh.bookshop.common.Constants.SIGN_UP
import com.sourabh.bookshop.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

//        Firebase.auth.currentUser?.let {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

        val titleList = arrayListOf(SIGN_IN, SIGN_UP)

        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.loginTabLayout, binding.viewPager) { tab, position ->
            tab.text = titleList[position]
        }.attach()
    }
}