package com.toolslab.languageoverride

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.toolslab.languageoverride.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(ActivityMainBinding.inflate(layoutInflater)) {
            setContentView(root)
        }
    }

}
