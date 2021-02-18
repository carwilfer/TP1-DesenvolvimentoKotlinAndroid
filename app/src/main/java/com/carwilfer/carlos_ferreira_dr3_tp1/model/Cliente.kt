package com.carwilfer.carlos_ferreira_dr3_tp1.model

class Cliente (
    val nome: String? = null,

    val cpf: String? = null
){
    override fun toString(): String = "$nome:  $cpf"

}