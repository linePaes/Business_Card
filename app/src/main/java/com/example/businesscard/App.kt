package com.example.businesscard

import android.app.Application
import com.example.businesscard.data.BusinessCardRepository
import com.example.businesscard.data.AppDataBase

class App :Application() {
    val database by lazy { AppDataBase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}
