package com.carwilfer.carlos_ferreira_dr3_tp1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Oculos (
    val marca: String? = null,
    val cor: String? = null,
    val lente: String? = null,
    val grau: String? = null,
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
){
    override fun toString(): String = "$marca:  $cor: $lente: $grau:"

}

/* //Relacao 1 pra muitos
@Entity
class Oculos (
        val clienteCreatorId: Long,

        val marca: String? = null,
        val cor: String? = null,
        val lente: String? = null,
        val grau: String? = null,
        @PrimaryKey(autoGenerate = true)
        var id: Long? = null
        )
*/
