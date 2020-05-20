package com.petyr47.simpleextensions

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.setupErrorClearWatcher() {

    val watcher = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {
            error = ""
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }
    this.editText?.addTextChangedListener(watcher)
}


@BindingAdapter("app:error")
fun bindError(view : TextInputLayout, error: String?){
    if (error != null){
        view.error = error
    }

}