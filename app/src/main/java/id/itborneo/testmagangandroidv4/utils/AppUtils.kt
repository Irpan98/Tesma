package id.itborneo.testmagangandroidv4.utils

import android.util.Log
import id.itborneo.testmagangandroidv4.BuildConfig
import id.itborneo.testmagangandroidv4.data.TAG_DEBUG
import id.itborneo.testmagangandroidv4.data.TAG_ERROR

fun logDebug(message: String) {
    if (BuildConfig.DEBUG) {
        Log.d(TAG_DEBUG, message)
    }
}

fun logError(message: String) {
    if (BuildConfig.DEBUG) {
        Log.e(TAG_ERROR, message)
    }
}