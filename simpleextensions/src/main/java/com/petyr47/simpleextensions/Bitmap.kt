package com.petyr47.simpleextensions

import android.graphics.*
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

@BindingAdapter("app:bitmap")
fun setImageBitmap(imageView: ImageView, bitmap: MutableLiveData<Bitmap>) {
    val owner = imageView.getParentActivity() as LifecycleOwner

    bitmap.observe(owner, Observer {
        it?.let {
            imageView.setImageBitmap(it)
        }
    })

}

fun Bitmap.toGrayScale() : Bitmap {
    val height: Int = height
    val width: Int = width
    val bmpGrayscale = Bitmap.createBitmap(
        width,
        height,
        Bitmap.Config.ARGB_8888
    )
    val c = Canvas(bmpGrayscale)
    val paint = Paint()
    val cm = ColorMatrix()
    cm.setSaturation(0.0f)
    val f = ColorMatrixColorFilter(cm)
    paint.colorFilter = f
    c.drawBitmap(this, 0.0f, 0.0f, paint)
    return bmpGrayscale
}

// Extension function to rotate a bitmap
fun Bitmap.rotate(degree: Int): Bitmap {
    // Initialize a new matrix
    val matrix = Matrix()

    // Rotate the bitmap
    matrix.postRotate(degree.toFloat())

    // Resize the bitmap
    val scaledBitmap = Bitmap.createScaledBitmap(
        this,
        width,
        height,
        true
    )

    // Create and return the rotated bitmap
    return Bitmap.createBitmap(
        scaledBitmap,
        0,
        0,
        scaledBitmap.width,
        scaledBitmap.height,
        matrix,
        true
    )
}