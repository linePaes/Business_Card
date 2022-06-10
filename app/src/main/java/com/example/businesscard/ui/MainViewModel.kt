package com.example.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscard.data.BusinessCard
import com.example.businesscard.data.BusinessCardRepository

//QUEM VAI TA CONVERSANDO COM NOSSA VIEW É MainViewModel
class MainViewModel(private val businessCardRepository: BusinessCardRepository): ViewModel() {
    //PASSANDO NOSSA ENTIDADE businessCard COMO PARAMETRO QUE VAI ESTAR PREENCHIDA ATRAVES DA NOSSA VIEW
    fun insert(businessCard: BusinessCard){
        businessCardRepository.insert(businessCard)
    }

    fun getAll() : LiveData<List<BusinessCard>>{
        return businessCardRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: BusinessCardRepository)
    : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKD_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}