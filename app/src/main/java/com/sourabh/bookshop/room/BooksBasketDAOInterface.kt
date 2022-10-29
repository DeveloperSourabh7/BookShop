package com.sourabh.bookshop.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sourabh.bookshop.model.BooksBasketRoomModel

@Dao
interface BooksBasketDAOInterface {

    @Insert
    fun addBookBasket(booksBasketRoomModel: BooksBasketRoomModel)

    @Query("SELECT * FROM booksbasketdatabase")
    fun getBooksBasket(): List<BooksBasketRoomModel>?

    @Query("SELECT bookName FROM booksbasketdatabase")
    fun getBooksNamesBasket(): List<String>?

    @Query("DELETE FROM booksbasketdatabase WHERE id = :idInput")
    fun deleteBookWithId(idInput: Int)

    @Query("DELETE FROM booksbasketdatabase")
    fun clearBasket()

}