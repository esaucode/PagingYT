package com.esaudev.pagingyt.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirestoreModule {

    @Singleton
    @Provides
    fun provideGetAllProductsQuery(): Query {
        return FirebaseFirestore.getInstance()
            .collection(FirestoreConstants.PRODUCTS_COLLECTION)
            .orderBy(FirestoreConstants.ORDER_BY_NAME_LABEL, Query.Direction.ASCENDING)
            .limit(FirestoreConstants.PAGE_SIZE.toLong())
    }

}