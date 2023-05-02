package com.example.keyboardevent

import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsAnimationCompat
import androidx.core.view.WindowInsetsAnimationCompat.*
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat.*
import com.example.keyboardevent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val insetsWithKeyboardCallback = InsetsWithKeyboardCallback(window)
        ViewCompat.setOnApplyWindowInsetsListener(binding.rootId, insetsWithKeyboardCallback)
        ViewCompat.setWindowInsetsAnimationCallback(binding.rootId, insetsWithKeyboardCallback)
        
        val insetsWithKeyboardAnimationCallback = InsetsWithKeyboardAnimationCallback(binding.button)
        ViewCompat.setWindowInsetsAnimationCallback(binding.button, insetsWithKeyboardAnimationCallback)

    }
}





