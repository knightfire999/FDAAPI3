package com.example.fdaapi3.activities

import android.os.Bundle
import com.example.fdaapi3.R
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.example.fdaapi3.models.Item
import com.example.fdaapi3.models.RecalledItem

class ItemDetailActivity : AppCompatActivity() {

    val TAG = "ItemDetailActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val item = intent.getParcelableExtra<RecalledItem>(EXTRA_ITEM)
        Log.d(TAG, "onCreate: " + item)
    }

    companion object {
        val EXTRA_ITEM = "item"
    }
}