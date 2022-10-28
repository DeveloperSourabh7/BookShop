package com.sourabh.bookshop.ui.main.payment

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sourabh.bookshop.model.BooksBasketRoomModel

class PaymentFragmentViewModel(context: Context) : ViewModel() {

//    private val booksRepo = BooksRepository(context)

    private var _booksBasket = MutableLiveData<List<BooksBasketRoomModel>>()
    val booksBasket: LiveData<List<BooksBasketRoomModel>>
        get() = _booksBasket

    init {
        getBooksBasket()
    }

    private fun getBooksBasket() {
//        booksRepo.booksBasket()
//        _booksBasket = booksRepo.booksBasketList
    }

    fun clearBasket() {
//        booksRepo.clearBasket()
    }

}