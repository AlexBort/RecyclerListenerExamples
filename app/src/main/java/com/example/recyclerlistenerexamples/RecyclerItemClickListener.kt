package com.example.recyclerlistenerexamples

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Author: AlexBort
 * Date: 23.08.2020
 *
 * Variant with overriding OnItemTouchListener into simple click listener
 */
class RecyclerItemClickListener(context: Context?, listener: ItemClickListener?) :
    RecyclerView.OnItemTouchListener {

    private var gestureDetector: GestureDetector
    private var clickListener: ItemClickListener

    init {
        this.clickListener = listener!!
        gestureDetector =
            GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent?): Boolean {
                    return true
                }
            })
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val childView: View? = rv.findChildViewUnder(e.x, e.y)
        if (childView != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onItemClick(childView, rv.getChildAdapterPosition(childView))
            return true
        }
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }


    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

}