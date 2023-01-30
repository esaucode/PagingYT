package com.esaudev.pagingyt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.esaudev.pagingyt.firebase.Constants.PAGE_SIZE
import com.esaudev.pagingyt.firebase.FirestorePagingSource
import com.google.firebase.firestore.Query
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllProductsQuery: Query
): ViewModel() {

    val flow = Pager(
        PagingConfig(
            pageSize = PAGE_SIZE
        )
    ) {
        FirestorePagingSource(getAllProductsQuery = getAllProductsQuery)
    }.flow.cachedIn(viewModelScope)

}