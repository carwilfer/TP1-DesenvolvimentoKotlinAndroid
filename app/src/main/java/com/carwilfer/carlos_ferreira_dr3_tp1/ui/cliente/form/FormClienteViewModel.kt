package com.carwilfer.carlos_ferreira_dr3_tp1.ui.cliente.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carwilfer.carlos_ferreira_dr3_tp1.data.RepositorioClientes
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente
import kotlinx.coroutines.launch

class FormClienteViewModel : ViewModel() {
    fun salvarCliente(nome: String, cpf: String) {
        val cliente = Cliente(nome, cpf)
        viewModelScope.launch{
            RepositorioClientes.getInstance().store(cliente)
        }
    }
}