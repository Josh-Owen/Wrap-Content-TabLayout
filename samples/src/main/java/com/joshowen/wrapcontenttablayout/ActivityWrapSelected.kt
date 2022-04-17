package com.joshowen.wrapcontenttablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.joshowen.wrapcontenttablayout.databinding.ActivityWrapSelectedBinding

class ActivityWrapSelected : AppCompatActivity() {

    //region Variables
    private lateinit var binding: ActivityWrapSelectedBinding

    //endregion

    //region Life-Cycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWrapSelectedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext.setOnClickListener {
            startActivity(ActivityWrapAll.newInstance(this))
        }
    }
    //endregion
}