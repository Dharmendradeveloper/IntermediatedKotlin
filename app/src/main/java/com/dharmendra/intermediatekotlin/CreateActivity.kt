package com.dharmendra.intermediatekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dharmendra.intermediatekotlin.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        intent.getStringExtra(NavigationActivity.FRAGMENT_VALUE_KEY).run {
            info.text = if (this == NavigationActivity.FRAGMENT_VALUE_TASK){
                "This is task"
            }else if(this == NavigationActivity.FRAGMENT_VALUE_NOTE){
                "This is Notes"
            }else{
                "Something went wrong"
            }
        }

    }
}