package com.example.nasacollection.domain

import com.example.nasacollection.domain.item.CollectionItem
import com.example.nasacollection.repositories.CollectionRepository
import javax.inject.Inject

class GetCollectionUseCase @Inject constructor(private val collectionRepository: CollectionRepository) {
    suspend operator fun invoke():CollectionItem{
        return collectionRepository.getData()
    }
}