package com.example.keyboardevent.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.keyboardevent.R
import com.example.keyboardevent.databinding.ActivityMain2Binding
import com.example.keyboardevent.databinding.ActivityMainBinding
import com.example.keyboardevent.fragments.bottom_sheet.BottomSheetDialogFragment

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }
}