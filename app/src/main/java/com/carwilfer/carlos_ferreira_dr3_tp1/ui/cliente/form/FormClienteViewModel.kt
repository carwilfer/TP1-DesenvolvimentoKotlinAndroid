package com.carwilfer.carlos_ferreira_dr3_tp1.ui.cliente.form

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carwilfer.carlos_ferreira_dr3_tp1.database.ClienteDao
import com.carwilfer.carlos_ferreira_dr3_tp1.database.RepositorioClientes
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente
import kotlinx.coroutines.launch
import java.lang.Exception

class FormClienteViewModel(
    private val clienteDao: ClienteDao
) : ViewModel() {

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
    val msg: LiveData<String> = _msg

    init {
        _status.value = false
        _msg.value = null
    }

    fun salvarCliente(nome: String, cpf: String) {
        _status.value = false
        _msg.value = "Por favor, aguarde a persistência!"

        viewModelScope.launch{
            val cliente = Cliente(nome, cpf)
            //val retornoCliente = RepositorioClientes.getInstance().store(cliente)
            //val retornoCliente = RepositorioClientes.getInstance().store(cliente)
            try {
                clienteDao.insert(cliente)
                _status.value = true //persistiu
                _msg.value = "Persistência realizada com sucesso!"
            } catch (e: Exception) {
                //não persistiu
                _msg.value = "Persistência falhou"
                Log.e("SQLite", "${e.message}")
            }
        }
    }
}