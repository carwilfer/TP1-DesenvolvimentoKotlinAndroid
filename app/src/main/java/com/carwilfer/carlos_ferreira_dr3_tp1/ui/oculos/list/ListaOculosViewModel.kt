package com.carwilfer.carlos_ferreira_dr3_tp1.ui.oculos.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carwilfer.carlos_ferreira_dr3_tp1.data.RepositorioOculos
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Oculos
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListaOculosViewModel : ViewModel() {
    private val _oculos = MutableLiveData<List<Oculos>>()
    val oculos: LiveData<List<Oculos>> = _oculos

    fun atualizarListaOculos(){
        Log.i("ListaOculosViewModel", "Atualizando Lista de Oculos")
        viewModelScope.launch {
            _oculos.value = RepositorioOculos.getInstance().all()
            Log.i("ListaOculosViewModel", "Oculos Atualizados.")
        }
        Log.i("ListaOculosViewModel", "Atualização Finalizada.")
    }
}