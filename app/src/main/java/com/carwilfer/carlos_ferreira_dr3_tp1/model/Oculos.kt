package com.carwilfer.carlos_ferreira_dr3_tp1.model

class Oculos (
    val marca: String? = null,
    val cor: String? = null,
    val lente: String? = null,
    val grau: String? = null,
){
    override fun toString(): String = "$marca:  $cor: $lente: $grau:"

}