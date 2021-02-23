package com.carwilfer.carlos_ferreira_dr3_tp1.database

import androidx.room.Insert
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Oculos

interface OculosDao {
    //insert
    @Insert
    suspend fun insert(oculos: Oculos)
    //update
    //select
    //delete

}