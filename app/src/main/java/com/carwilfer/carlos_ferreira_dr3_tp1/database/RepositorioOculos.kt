package com.carwilfer.carlos_ferreira_dr3_tp1.database

import com.carwilfer.carlos_ferreira_dr3_tp1.model.Oculos
import kotlinx.coroutines.delay
import kotlin.random.Random

class RepositorioOculos {
    private val oculos = mutableListOf(
        Oculos("Prada", "Preto", "Perto", "grau 0,5"),
        Oculos("Ray-Ban", "Verde", "Polarizado", "grau 1,5"),
        Oculos("Reef", "Branco", "Polarizado", "grau 1,0"),

    )

    suspend fun all():List<Oculos> {
        delay(5000)
        return oculos
    }

    suspend fun store(_oculos: Oculos): Boolean {
        delay(5000)
        oculos.add(_oculos)
        //return Random.nextBoolean()
        return Random.nextInt(100) < 90
    }

    companion object{
        private var instance: RepositorioOculos? = null
        fun getInstance(): RepositorioOculos{
            if(instance == null)
                instance = RepositorioOculos()
            return instance as RepositorioOculos
        }
    }
}