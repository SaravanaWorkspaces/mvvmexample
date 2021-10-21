package com.skc.mvvmexample.io

import android.util.Log
import com.skc.mvvmexample.AppController
import com.skc.mvvmexample.R
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.lang.Exception

/**

@author Saravana kumar Chinnaraj
@Date 20,October,2021
@version 1.0
 */
class DataSource {

    companion object {
        private val TAG = "DataSource"
    }

    fun executeRequest(requestFile : Int) : String? {
        val inStream = AppController.applicationContext().resources.openRawResource(requestFile)
        return convertIoSToString(inStream)
    }

    private fun convertIoSToString(stream : InputStream) : String? {
        try{
            val bos = ByteArrayOutputStream()
            stream.copyTo(bos)
            return bos.toString()
        } catch (e: Exception) {
            Log.d(TAG, e.localizedMessage)
        }
        return null
    }
}