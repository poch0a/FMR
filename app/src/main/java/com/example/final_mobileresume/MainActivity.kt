package com.example.final_mobileresume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navigation: NavController
    lateinit var toggles : ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerLayout)
        val navigationView: NavigationView = findViewById(R.id.navigationView)
        toggles = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggles)
        toggles.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.navigation_HomeScreen -> replaceFragment(HomeScreen(),it.title.toString())
                R.id.navigation_AboutMe -> replaceFragment(AboutMe(),it.title.toString())
                R.id.navigation_ProjectDevelopments -> replaceFragment(ProjectDevelopment(),it.title.toString())
                R.id.navigation_ContactForm -> replaceFragment(ContactForm(),it.title.toString())
            }
            true
        }
        val navigationFragment = supportFragmentManager.findFragmentById(R.id.fragments) as NavHostFragment
        navigation = navigationFragment.navController
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggles.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment, title:String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragments,fragment)
        fragmentTransaction.commit()
        drawerLayout.close()
        setTitle(title)
    }
}