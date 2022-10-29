package com.sourabh.bookshop.ui.main.bookdetail

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sourabh.bookshop.model.BooksBasketRoomModel
import com.sourabh.bookshop.repository.BooksRepository

class BookDetailBottomSheetViewModel(context: Context) : ViewModel() {

    private var booksRepo = BooksRepository(context)

    private var _isBookAddedBasket = MutableLiveData<Boolean>()
    val isBookAddedBasket: LiveData<Boolean>
        get() = _isBookAddedBasket

    init {
        _isBookAddedBasket = booksRepo.isBookAddedBasket
    }

    fun addBookToBasket(bookModel: BooksBasketRoomModel) {
        booksRepo.addBookToBasket(bookModel)
    }
}