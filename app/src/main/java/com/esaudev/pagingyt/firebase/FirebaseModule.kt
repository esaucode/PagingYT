package com.esaudev.pagingyt.firebase

import androidx.transition.Visibility.Mode
import com.esaudev.pagingyt.firebase.Constants.PAGE_SIZE
import com.esaudev.pagingyt.firebase.Constants.PRODUCTS_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideGetAllProductsQuery() = FirebaseFirestore.getInstance()
        .collection(PRODUCTS_COLLECTION)
        .orderBy("name", Query.Direction.ASCENDING)
        .limit(PAGE_SIZE.toLong())
}