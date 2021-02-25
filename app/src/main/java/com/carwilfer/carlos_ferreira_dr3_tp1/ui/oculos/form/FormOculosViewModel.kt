package com.carwilfer.carlos_ferreira_dr3_tp1.ui.oculos.form

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carwilfer.carlos_ferreira_dr3_tp1.database.*
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Oculos
import kotlinx.coroutines.launch
import java.lang.Exception

class FormOculosViewModel(
    private val oculosDao: OculosDao,
    private val clienteDao: ClienteDao
) : ViewModel() {
    //private val _cliente = MutableLiveData<List<Cliente>>()
    //val cliente: LiveData<List<Cliente>> = _cliente

    /*fun atualizarListaOculos(){
        viewModelScope.launch {
            _oculos.value = RepositorioOculos.getInstance().all()
        }*/


    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status
    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    init {
        _status.value = false
        _msg.value = null
    }
    fun salvarOculos(marca: String, cor: String, lente: String, grau: String, nome: String, cpf: String) {
        _status.value = false
        _msg.value = "Por favor, aguarde a persistência!"

        viewModelScope.launch {
            //val oculos = Oculos(marca, cor, lente, grau)
            //AppDatabase.getInstance().oculosDao().insert(oculos)
            //val retornoOculos = RepositorioOculos.getInstance().store(oculos)

            try  {
                val oculos = Oculos(marca, cor, lente, grau)
                if(OculosUtil.oculosSelecionado != null) {
                    oculos.id = OculosUtil.oculosSelecionado!!.id
                    oculosDao.update(oculos)
                } else {
                    val oculosId = oculosDao.insert(oculos)
                    // consultar pelo oculos para pegar o seu id
                    //atualizar o cliente com esse oculos
                    // pegar o ID do cliente que foi selecionado no spinner
                    val cliente = clienteDao.readNome(cpf)
                    // pegar esse cliente, e atribuir ao atribuito oculosId, o id do oculos cadastrdo
                    cliente.oculosId = oculosId
                    // atualizar o cliente que recebeu o oculusId
                    clienteDao.update(cliente)
                }
                _status.value = true //persistiu
                _msg.value = "Persistência realizada com sucesso!"
            } catch (e: Exception){
                _msg.value = "Persistência falhou"//não persistiu
                Log.e("SQLite", "${e.message}")
            }
        }
    }
}