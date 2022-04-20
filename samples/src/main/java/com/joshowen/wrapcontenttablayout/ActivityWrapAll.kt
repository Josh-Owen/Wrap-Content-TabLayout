package com.joshowen.wrapcontenttablayout

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.joshowen.wrapcontenttablayout.databinding.ActivityWrapAllBinding

class ActivityWrapAll : AppCompatActivity() {

    //region Variables
    private lateinit var binding: ActivityWrapAllBinding

    //endregion

    //region Life-Cycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWrapAllBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //endregion

    //region Toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
    //endregion

    //region Companion Object
    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, ActivityWrapAll::class.java)
        }
    }
    //endregion

}