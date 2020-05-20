package com.petyr47.simpleextensions

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.hideOnScroll(component : View) {
    // Retrieve and cache the system's default "short" animation time.
    val mediumAnimationDuration = resources.getInteger(android.R.integer.config_mediumAnimTime)

    this.addOnScrollListener(object : RecyclerView.OnScrollListener(){
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            if (dy > 0 && component.visibility == View.VISIBLE) {

                component.animate()
                    .alpha(0f)
                    .setDuration(mediumAnimationDuration.toLong())
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            component.visibility = View.GONE
                        }
                    })

            } else if (dy < 0 && component.visibility != View.VISIBLE) {

                component.animate()
                    .alpha(1f)
                    .setDuration(mediumAnimationDuration.toLong())
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            //super.onAnimationEnd(animation)
                            component.visibility = View.VISIBLE
                        }
                    })

            }
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)

            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                component.animate()
                    .alpha(1f)
                    .setDuration(mediumAnimationDuration.toLong())
                    .setListener(object : AnimatorListenerAdapter(){
                        override fun onAnimationEnd(animation: Animator?) {
                            //super.onAnimationEnd(animation)
                            component.visibility = View.VISIBLE
                        }
                    })
            }
        }
    })
}