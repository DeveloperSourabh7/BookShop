package com.sourabh.bookshop.common.util

import com.sourabh.bookshop.common.Constants.BASE_URL
import com.sourabh.bookshop.retrofit.BooksDAOInterface
import com.sourabh.bookshop.retrofit.RetrofitClient

class ApiUtils {

    companion object {

        fun getBooksDAOInterface(): BooksDAOInterface {
            return RetrofitClient.getClient(BASE_URL).create(BooksDAOInterface::class.java)
        }
    }
}