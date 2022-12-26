package com.lorikyo.recipestash.data

import androidx.room.withTransaction
import javax.inject.Inject

class TransactionProvider @Inject constructor(private val db: AppDatabase) {

    suspend fun <R> runAsTransaction(block: suspend () -> R): R {
        return db.withTransaction(block)
    }
}