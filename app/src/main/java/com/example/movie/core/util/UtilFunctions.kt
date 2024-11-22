package com.example.movie.core.util

import timber.log.Timber

class UtilFunctions {
    fun logError(tag:String, message: String){
        Timber.tag(tag).e("error ->${message}")
    }

    fun logInfo(tag:String, message: String){
        Timber.tag(tag).i("info ->${message}")
    }
}