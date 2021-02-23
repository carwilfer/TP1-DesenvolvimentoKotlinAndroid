package com.carwilfer.carlos_ferreira_dr3_tp1.database

import androidx.room.*
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Oculos
import com.carwilfer.carlos_ferreira_dr3_tp1.model.OculosAndCliente

@Dao
interface OculosDao {
    //insert
    @Insert
    suspend fun insert(oculos: Oculos)

    //update
    @Update
    suspend fun update(oculos: Oculos)

    //select
    @Transaction
    @Query("SELECT * FROM Oculos WHERE id = :key")
    suspend fun read(key: Long): OculosAndCliente

    //delete
    @Delete
    suspend fun delete(oculos: Oculos)

    //List
    @Query("SELECT * FROM Oculos")
    suspend fun all(): List<Oculos>

}