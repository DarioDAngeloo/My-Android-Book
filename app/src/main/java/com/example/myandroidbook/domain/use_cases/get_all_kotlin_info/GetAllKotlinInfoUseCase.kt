package com.example.myandroidbook.domain.use_cases.get_all_kotlin_info

import androidx.paging.PagingData
import com.example.myandroidbook.data.repository.Repository
import com.example.myandroidbook.domain.model.KotlinModel
import kotlinx.coroutines.flow.Flow

class GetAllKotlinInfoUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<KotlinModel>> {
        return repository.getAllKotlinInfo()
    }
}