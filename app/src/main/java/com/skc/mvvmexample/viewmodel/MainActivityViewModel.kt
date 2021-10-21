package com.skc.mvvmexample.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skc.mvvmexample.model.IceCream
import com.skc.mvvmexample.repository.IceCreamRepository


/**

@author Saravana kumar Chinnaraj
@Date 18,October,2021
@version 1.0
 */
class MainActivityViewModel() : ViewModel() {

    private var repository: IceCreamRepository = IceCreamRepository()

    private val iceCreamList: MutableLiveData<List<IceCream>> by lazy {
        MutableLiveData<List<IceCream>>().also { it ->
            it.value = repository.getIceCreams()
        }
    }

    fun getIceCreamList() : LiveData<List<IceCream>> {
        return iceCreamList
    }
}