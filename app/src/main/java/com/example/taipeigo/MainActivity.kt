package com.example.taipeigo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE: Int=555
    private var login=false
    private var TAG=this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        if(!login) {
            val intent=Intent(this,LoginActivity::class.java)
            startActivityForResult(intent,REQUEST_CODE)
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.bottom_menu_home -> {
                    Title.text=item.title
                    findNavController(R.id.navfragment).navigate(
                        R.id.homeFragment
                    )

                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bottom_menu_search -> {
                    Title.text=item.title
                    findNavController(R.id.navfragment).navigate(
                        R.id.searchFragment
                    )
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bottom_menu_bookmarks -> {
                    Title.text=item.title
                    findNavController(R.id.navfragment).navigate(
                        R.id.bookmarksFragment
                    )
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.bottom_menu_account -> {
                    Title.text=item.title
                    findNavController(R.id.navfragment).navigate(
                        R.id.accountFragment
                    )
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                login=true
            }
        } else {
            Log.d(TAG, "REQUESTCODE ERROR!")
            finish()
        }
    }
}