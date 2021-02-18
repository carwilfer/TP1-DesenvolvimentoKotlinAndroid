package com.carwilfer.carlos_ferreira_dr3_tp1.data

import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente
import kotlinx.coroutines.delay
import kotlin.random.Random

class RepositorioClientes {
    private val cliente = mutableListOf(
        Cliente("Carlos", "551.552.553-55"),
        Cliente("Alê", "775.776.777-77"),
        Cliente("Alice", "445.446.447-44"),
    )

    suspend fun all():List<Cliente> {
        delay(5000)
        return cliente
    }

    suspend fun store(_cliente: Cliente) {
        delay(5000)
        cliente.add(_cliente)
        //return Random.nextInt(100) < 90
    }

    companion object{
        private var instance: RepositorioClientes? = null
        fun getInstance(): RepositorioClientes{
            if(instance == null)
                instance = RepositorioClientes()
            return instance as RepositorioClientes
        }
    }
}