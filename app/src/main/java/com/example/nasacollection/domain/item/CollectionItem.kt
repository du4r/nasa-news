package com.example.nasacollection.domain.item

import com.example.nasacollection.models.NasaData

data class CollectionItem(
    val title: String?,
    val date: String?,
    val explanation: String?,
    val url: String?,
    val media_type: String?
){
    companion object{
        fun getInstance() = CollectionItem(null,null,null,null,null)
    }
}


fun NasaData.toCollectionItem() = CollectionItem(title,date,explanation,url,media_type)