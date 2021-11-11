package com.example.mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


//        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
//        val adapter = RecyclerAdapter()
//        recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        recyclerview.adapter = adapter

        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment(), it.title.toString())
                R.id.nav_message -> replaceFragment(MessageFragment(), it.title.toString())
            }
            true

        }
    }

    private fun replaceFragment(fragment: Fragment, title: String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return onOptionsItemSelected(item)
    }
}