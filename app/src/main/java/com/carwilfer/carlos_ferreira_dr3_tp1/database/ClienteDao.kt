package com.carwilfer.carlos_ferreira_dr3_tp1.database

import androidx.room.Dao
import androidx.room.Insert
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente

@Dao
interface ClienteDao {
    //insert
    @Insert
    fun insert(cliente: Cliente)
    //update
    //select
    //delete

}