package com.example.nasacollection.repositories

import com.example.nasacollection.data.DataService
import com.example.nasacollection.domain.item.CollectionItem
import javax.inject.Inject

class CollectionRepository @Inject constructor(private val dataService: DataService) {
    suspend fun getData():CollectionItem{
        return dataService.getData()
    }
}