package com.carwilfer.carlos_ferreira_dr3_tp1.ui.cliente.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carwilfer.carlos_ferreira_dr3_tp1.database.ClienteDao
import com.carwilfer.carlos_ferreira_dr3_tp1.ui.oculos.form.FormOculosViewModel
import java.lang.IllegalArgumentException

class FormClienteViewModelFactory (
    val clienteDao: ClienteDao
        ) : ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FormClienteViewModel::class.java)){
            return FormClienteViewModel(clienteDao) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}