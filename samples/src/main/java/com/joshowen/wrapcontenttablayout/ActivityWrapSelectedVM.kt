package com.joshowen.wrapcontenttablayout

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityWrapSelectedVM : ViewModel() {

    //region Variables
    val wrappedTabs = MutableLiveData(arrayOf(0))

    //endregion
}