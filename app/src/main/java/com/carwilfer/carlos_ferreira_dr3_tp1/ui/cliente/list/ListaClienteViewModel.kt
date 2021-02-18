package com.carwilfer.carlos_ferreira_dr3_tp1.ui.cliente.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carwilfer.carlos_ferreira_dr3_tp1.data.RepositorioClientes
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente
import kotlinx.coroutines.launch

class ListaClienteViewModel : ViewModel() {

    private val _clientes = MutableLiveData<List<Cliente>>()
    val clientes: LiveData<List<Cliente>> = _clientes

    fun atualizarListaClientes(){
        Log.i("ListaClientesViewModel", "Atualizando Lista de Clientes")
        viewModelScope.launch {
            _clientes.value = RepositorioClientes.getInstance().all()
            Log.i("ListaClienteViewModel", "Clientes Atualizados.")
        }
        Log.i("ListaClienteViewModel", "Atualização Finalizada.")
    }
}