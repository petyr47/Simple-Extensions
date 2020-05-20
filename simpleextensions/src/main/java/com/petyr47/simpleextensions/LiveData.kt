package com.petyr47.simpleextensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


fun <T> MutableLiveData<T>.refresh() {
    this.value = this.value
}

/*
* function to protect an observer when livedata returns null
*
* param[observer] will only run when the value being observed has changed and is not null
*
*
* */

fun <T> LiveData<T>.nonNullObserve(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(owner, androidx.lifecycle.Observer {
        it?.let(observer)
    })
}


