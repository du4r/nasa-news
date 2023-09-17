package com.example.nasacollection.data

import com.example.nasacollection.domain.item.CollectionItem
import com.example.nasacollection.domain.item.toCollectionItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataService @Inject constructor(private val nasaApi: NasaApi) {
    suspend fun getData(): CollectionItem{
        return withContext(Dispatchers.IO){
            val collection = nasaApi.getData()
            collection.body()?.toCollectionItem() ?: throw Exception("collection not found!!!")
        }
    }
}