package com.example.nasacollection.data

import com.example.nasacollection.domain.item.CollectionItem
import com.example.nasacollection.domain.item.toCollectionItem
import com.example.nasacollection.utils.Constants.Companion.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataService @Inject constructor(private val nasaApi: NasaApi) {
    suspend fun getData(): CollectionItem{
        return withContext(Dispatchers.IO){
            val collection = nasaApi.getData(API_KEY)
            collection.body()?.toCollectionItem() ?: throw Exception("collection not found!!!")
        }
    }
}