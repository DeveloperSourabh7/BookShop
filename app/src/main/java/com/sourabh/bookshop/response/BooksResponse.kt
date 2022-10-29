package com.sourabh.bookshop.response

import com.google.gson.annotations.SerializedName
import com.sourabh.bookshop.model.BookModel

data class BooksResponse(
    @SerializedName("books") var books: List<BookModel>,
    @SerializedName("success") var success: Int
)