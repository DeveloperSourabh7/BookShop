package com.sourabh.bookshop.model

data class ParentItem(
    var title: String,
    var ChildItemList: List<ChildItem>
)
