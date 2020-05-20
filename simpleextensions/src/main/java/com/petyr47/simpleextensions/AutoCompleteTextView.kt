package com.petyr47.simpleextensions

import android.R
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData

@BindingAdapter("app:list")
fun setAdapterToNewList(view: AutoCompleteTextView, list: LiveData<List<String>>) {
    val adapter =  ArrayAdapter(
        view.context,
        R.layout.simple_spinner_dropdown_item,
        list.value ?: listOf()
    )
    view.setAdapter(adapter)
}