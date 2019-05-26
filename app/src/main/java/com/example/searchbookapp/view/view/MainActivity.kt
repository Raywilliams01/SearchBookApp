package com.example.searchbookapp.view.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.searchbookapp.R
import com.example.searchbookapp.view.viewmodal.BookItemViewModal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var bookItemViewModal: BookItemViewModal
    private val bookItemAdapter = BookAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookItemViewModal = ViewModelProviders.of(this).get(BookItemViewModal::class.java)
        bookItemViewModal.refresh()

        main_activity_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookItemAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        bookItemViewModal.bookItemList.observe(this, Observer { books ->
            books?.let { bookItemAdapter.updateBookList(it) }
        })

        bookItemViewModal.bookLoadError.observe(this, Observer { isError ->
            isError?.let { textView.visibility = if (it) View.VISIBLE else View.GONE }
        })

        bookItemViewModal.loading.observe(this, Observer { isLoading ->
            isLoading.let {
                main_progress_bar.visibility = if(it) View.VISIBLE else View.GONE
                if(it){
                    textView.visibility = View.GONE
                    main_activity_recycler_view.visibility = View.GONE
                }
            }
        })
    }
}
