package com.carwilfer.carlos_ferreira_dr3_tp1.ui.oculos.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carwilfer.carlos_ferreira_dr3_tp1.data.RepositorioClientes
import com.carwilfer.carlos_ferreira_dr3_tp1.data.RepositorioOculos
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Oculos
import kotlinx.coroutines.launch

class FormOculosViewModel : ViewModel() {
    fun salvarOculos(marca: String, cor: String, lente: String, grau: String) {
        val oculos = Oculos(marca, cor, lente, grau)

        viewModelScope.launch {
        RepositorioOculos.getInstance().store(oculos)

        }

    }



    // TODO: Implement the ViewModel
}