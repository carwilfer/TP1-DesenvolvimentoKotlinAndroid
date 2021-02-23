package com.carwilfer.carlos_ferreira_dr3_tp1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Cliente (
    val nome: String? = null,
    val cpf: String? = null,
    val oculosId: Long? = null,
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

){
    override fun toString(): String = "$nome:  $cpf:"

}

