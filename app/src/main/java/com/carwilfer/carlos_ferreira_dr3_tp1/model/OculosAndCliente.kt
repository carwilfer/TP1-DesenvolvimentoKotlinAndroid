package com.carwilfer.carlos_ferreira_dr3_tp1.model

import androidx.room.Embedded
import androidx.room.Relation

class OculosAndCliente (
        @Embedded val oculos: Oculos,

        @Relation(
                parentColumn = "id",
                entityColumn = "oculosId"

        )
        val cliente: Cliente
) {
        override fun toString(): String = "Oculos:" +
                "${oculos.marca}\t" +
                "${oculos.cor}\t" +
                "${oculos.lente}\t" +
                "${oculos.grau}\t" +
                "${cliente.nome}\t" +
                "${cliente.cpf}"

}