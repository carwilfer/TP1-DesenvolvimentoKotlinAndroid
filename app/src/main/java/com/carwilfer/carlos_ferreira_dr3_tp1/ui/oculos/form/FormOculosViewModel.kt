package com.carwilfer.carlos_ferreira_dr3_tp1.ui.oculos.form

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carwilfer.carlos_ferreira_dr3_tp1.database.OculosDao
import com.carwilfer.carlos_ferreira_dr3_tp1.database.RepositorioOculos
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Oculos
import kotlinx.coroutines.launch
import java.lang.Exception

class FormOculosViewModel(
    private val oculosDao: OculosDao
) : ViewModel() {

    private val _oculos = MutableLiveData<List<Oculos>>()
    val oculos: LiveData<List<Oculos>> = _oculos

    fun atualizarListaOculos(){
        viewModelScope.launch {
            _oculos.value = RepositorioOculos.getInstance().all()
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
    fun salvarOculos(marca: String, cor: String, lente: String, grau: String) {
        _status.value = false
        _msg.value = "Por favor, aguarde a persistência!"

        viewModelScope.launch {
            val oculos = Oculos(marca, cor, lente, grau)
            //AppDatabase.getInstance().oculosDao().insert(oculos0
            //val retornoOculos = RepositorioOculos.getInstance().store(oculos)

            try  {
                oculosDao.insert(oculos)
                _status.value = true //persistiu
                _msg.value = "Persistência realizada com sucesso!"
            } catch (e: Exception){
                _msg.value = "Persistência falhou"//não persistiu
                Log.e("SQLite", "${e.message}")
            }
        }
    }
}