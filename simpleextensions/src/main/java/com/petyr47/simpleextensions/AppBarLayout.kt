package com.petyr47.simpleextensions

import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout

/*
* Attaches Motion layout to Appbar to translate motion between the
* two view elements in a coordinator view
* */
fun AppBarLayout.connectToMotionLayout(motionLayout: MotionLayout){
    val listener = AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
        val seekPosition = -verticalOffset / this.totalScrollRange.toFloat()
        motionLayout.progress = seekPosition
    }
    this.addOnOffsetChangedListener(listener)
}