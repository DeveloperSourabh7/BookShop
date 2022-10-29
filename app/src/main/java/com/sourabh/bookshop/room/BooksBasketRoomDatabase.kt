package com.sourabh.bookshop.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sourabh.bookshop.model.BooksBasketRoomModel

@Database(entities = [BooksBasketRoomModel::class], version = 1)
abstract class BooksBasketRoomDatabase : RoomDatabase() {

    abstract fun booksBasketDAOInterface(): BooksBasketDAOInterface

    companion object {

        private var instance: BooksBasketRoomDatabase? = null

        fun booksBasketRoomDatabase(context: Context): BooksBasketRoomDatabase? {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    BooksBasketRoomDatabase::class.java,
                    "booksbasketdatabase.db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}