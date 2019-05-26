package com.example.searchbookapp.view.viewmodal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchbookapp.view.modal.BookItemList

// Create View Modal for List View
// To have live Data
class BookItemViewModal: ViewModel() {

    val bookItemList = MutableLiveData<List<BookItemList>>()
    val bookLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        getBookList()
    }

    private fun getBookList() {
        val mockBook = listOf(
            BookItemList(auth = "Bob", authBookTitle = "Burger"),
            BookItemList(auth = "Bob", authBookTitle = "Burger"),
            BookItemList(auth = "Bob", authBookTitle = "Burger"),
            BookItemList(auth = "Bob", authBookTitle = "Burger"),
            BookItemList(auth = "Bob", authBookTitle = "Burger"),
            BookItemList(auth = "Bob", authBookTitle = "Burger"),
            BookItemList(auth = "Bob", authBookTitle = "Burger"),
            BookItemList(auth = "Bob", authBookTitle = "Burger")
        )

        bookLoadError.value = false
        loading.value = false

        bookItemList.value = mockBook
    }
}