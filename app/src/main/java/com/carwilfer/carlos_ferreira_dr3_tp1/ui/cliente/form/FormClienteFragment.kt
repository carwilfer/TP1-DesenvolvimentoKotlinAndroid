package com.carwilfer.carlos_ferreira_dr3_tp1.ui.cliente.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.carwilfer.carlos_ferreira_dr3_tp1.R
import kotlinx.android.synthetic.main.form_cliente_fragment.*

class FormClienteFragment : Fragment() {

    private lateinit var viewModel: FormClienteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_cliente_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormClienteViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabFormClienteSalvar.setOnClickListener{
            val nome = editTextFormeClienteNome.text.toString()
            val cpf = editTextFormeClienteCPF.text.toString()
            viewModel.salvarCliente(nome, cpf)

        }
    }

}