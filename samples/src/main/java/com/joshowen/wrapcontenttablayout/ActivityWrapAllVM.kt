package com.joshowen.wrapcontenttablayout

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityWrapAllVM : ViewModel() {

    //region Variables
    val shouldWrapAll = MutableLiveData(true)

    //endregion
}