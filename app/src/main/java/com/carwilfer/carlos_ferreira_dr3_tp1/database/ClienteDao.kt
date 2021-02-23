package com.carwilfer.carlos_ferreira_dr3_tp1.database

import androidx.room.*
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente

@Dao
interface ClienteDao {
    //insert
    @Insert
    suspend fun insert(cliente: Cliente)

    //update
    @Update
    suspend fun update(cliente: Cliente)

    //select Read
    @Query("SELECT * FROM Cliente WHERE id = :key")
    suspend fun read(key: Long): Cliente

    //delete
    @Delete
    suspend fun delete(cliente: Cliente)

    //List
    @Query("SELECT * FROM Cliente")
    suspend fun all(): List<Cliente>

}