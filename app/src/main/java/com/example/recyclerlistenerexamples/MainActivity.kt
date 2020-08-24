package com.example.recyclerlistenerexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(baseContext,
                object : RecyclerItemClickListener.ItemClickListener {
                    override fun onItemClick(view: View, position: Int) {

                    }
                })
        )

    }
}