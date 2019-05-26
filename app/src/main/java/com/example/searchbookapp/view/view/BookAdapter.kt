package com.example.searchbookapp.view.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchbookapp.R
import com.example.searchbookapp.view.modal.BookItemList
import kotlinx.android.synthetic.main.custom_listview.view.*

class BookAdapter( var bookItemList: ArrayList<BookItemList> ): RecyclerView.Adapter<BookAdapter.BookItemListViewHolderAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BookItemListViewHolderAdapter(
        LayoutInflater.from(parent.context).inflate(R.layout.custom_listview, parent, false)
    )

    override fun getItemCount() = bookItemList.size

    override fun onBindViewHolder(holder: BookItemListViewHolderAdapter, position: Int) {
        holder.bind(bookItemList[position])
    }

    fun updateBookList(newBookItemList: List<BookItemList>){
        bookItemList.clear()
        bookItemList.addAll(newBookItemList)
        notifyDataSetChanged()
    }


    class BookItemListViewHolderAdapter(view: View): RecyclerView.ViewHolder(view){

        private val authName = view.bookAuth
        private val bookTitle = view.bookTitle

        fun bind(bookItem: BookItemList){

            authName.text = bookItem.auth
            bookTitle.text = bookItem.authBookTitle
        }
    }

}