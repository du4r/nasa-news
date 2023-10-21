package com.example.nasacollection.ui.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasacollection.domain.GetCollectionUseCase
import com.example.nasacollection.domain.item.CollectionItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewmodel @Inject constructor(private val getCollectionUseCase: GetCollectionUseCase) : ViewModel() {

    private val _collection = MutableStateFlow(CollectionItem(null,null,null,null,null))

    val collection get() =  _collection

    val errorBody = MutableStateFlow(emptyList<String>())

    init {
        getCollections()
    }

    fun getCollections(){
        viewModelScope.launch {
                try {
                    val req = getCollectionUseCase()
                    _collection.value = req
                }catch (e: Exception){
                    val erros = mutableListOf<String>()
                    erros.add(e.message.toString())
                    errorBody.value = erros
                }
        }
    }
}