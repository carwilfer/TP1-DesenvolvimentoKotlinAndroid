package com.carwilfer.carlos_ferreira_dr3_tp1.ui.cliente.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carwilfer.carlos_ferreira_dr3_tp1.database.RepositorioClientes
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente
import kotlinx.coroutines.launch

class FormClienteViewModel : ViewModel() {

    private val _cliente = MutableLiveData<List<Cliente>>()
    val clientes: LiveData<List<Cliente>> = _cliente

    fun atualizarListaClientes(){
        viewModelScope.launch {
            _cliente.value = RepositorioClientes.getInstance().all()
        }
    }

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status
    private val _msg = MutableLiveData<String>()
    val msg: LiveData<Boolean> = _status

    init {
        _status.value = false
        _msg.value = null
    }

    fun salvarCliente(nome: String, cpf: String) {
        _status.value = false
        _msg.value = "Por favor, aguarde a persistência!"
        val cliente = Cliente(nome, cpf)
        viewModelScope.launch{
            val retornoCliente = RepositorioClientes.getInstance().store(cliente)

            if (retornoCliente) {
                _status.value = true //persistiu
                _msg.value = "Persistência realizada com sucesso!"
            }
            else //não persistiu
                _msg.value = "Persistência falhou"

        }
    }
}