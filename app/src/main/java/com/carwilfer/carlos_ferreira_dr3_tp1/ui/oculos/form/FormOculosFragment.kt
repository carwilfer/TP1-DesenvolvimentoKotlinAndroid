package com.carwilfer.carlos_ferreira_dr3_tp1.ui.oculos.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.carwilfer.carlos_ferreira_dr3_tp1.R
import com.carwilfer.carlos_ferreira_dr3_tp1.ui.cliente.list.ListaClienteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.form_oculos_fragment.*
import kotlinx.android.synthetic.main.lista_oculos_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FormOculosFragment : Fragment() {

    private lateinit var viewModel: FormOculosViewModel
    private lateinit var viewModelCliente: ListaClienteViewModel
    ///private lateinit var fabFormOculosSalvar: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?

    {
        viewModelCliente = ViewModelProvider(this).get(ListaClienteViewModel::class.java)
        viewModelCliente.clientes.observe(viewLifecycleOwner){
            var adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                it
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerListaCliente.adapter = adapter
        }
        return inflater.inflate(R.layout.form_oculos_fragment, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormOculosViewModel::class.java)

        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fabFormOculosSalvar.setOnClickListener{
            val marca = editTextOculosMarca.text.toString()
            val cor = editTextOculosCor.text.toString()
            val lente = editTextOculosLente.text.toString()
            val grau = editTextOculosGrau.text.toString()
            viewModel.salvarOculos(marca, cor, lente, grau)

        }

    }


}