package com.skc.mvvmexample.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.skc.mvvmexample.R
import com.skc.mvvmexample.io.DataSource
import com.skc.mvvmexample.model.IceCream

/**
* @author Saravana kumar Chinnaraj
* @Date 18,October,2021
* @version 1.0
**/
class IceCreamRepository {

    var iceCreamList : ArrayList<IceCream> = ArrayList()

    fun getIceCreams() : ArrayList<IceCream> {
        fetchIceCreams()
        return iceCreamList
    }

    private fun fetchIceCreams() {
        val dataSource = DataSource()
        val result = dataSource.executeRequest(R.raw.ice_cream)

        val gson = Gson()
        val listPersonType = object : TypeToken<List<IceCream>>() {}.type
        iceCreamList = gson.fromJson(result, listPersonType)
    }
}