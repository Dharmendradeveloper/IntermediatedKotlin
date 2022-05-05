package com.dharmendra.intermediatekotlin.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

import android.os.Bundle
import android.view.MenuItem
import android.view.TouchDelegate
import androidx.fragment.app.Fragment
import com.dharmendra.intermediatekotlin.CreateActivity
import com.dharmendra.intermediatekotlin.task.NotesListFragment
import com.dharmendra.intermediatekotlin.R
import com.dharmendra.intermediatekotlin.task.TaskListFragment
import kotlinx.android.synthetic.main.activity_navigation.*


class NavigationActivity : AppCompatActivity(),TaskListFragment.TouchActionDelegate,NotesListFragment.TouchActionDelegate {

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item:MenuItem ->
            when (item.itemId) {
                R.id.navigation_tasks -> {
//                    messageView.setText(R.string.title_task)
                    replaceFragment(TaskListFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notes -> {
//                    messageView.setText(R.string.title_note)
                    replaceFragment(NotesListFragment.newInstance())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
//        messageView.text = getString(R.string.title_task)
        replaceFragment(TaskListFragment.newInstance())

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun replaceFragment(fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout,fragment)
            .commit()
    }

    private fun gotoCreateActivity(fragmentValue:String){
        startActivity(Intent(this,CreateActivity::class.java).apply {
            putExtra(FRAGMENT_VALUE_KEY,fragmentValue)
        })
    }

    override fun onAddButtonClicked(value:String) {
        gotoCreateActivity(value)
    }

    companion object{
        const val FRAGMENT_VALUE_KEY = "f_v_k"
        const val FRAGMENT_VALUE_NOTE = "f_v_n"
        const val FRAGMENT_VALUE_TASK = "f_v_t"
    }

}