package com.carwilfer.carlos_ferreira_dr3_tp1.ui.oculos.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.carwilfer.carlos_ferreira_dr3_tp1.LogRegister
import com.carwilfer.carlos_ferreira_dr3_tp1.database.OculosUtil
import com.carwilfer.carlos_ferreira_dr3_tp1.R
import com.carwilfer.carlos_ferreira_dr3_tp1.database.AppDatabase
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Oculos
import com.carwilfer.carlos_ferreira_dr3_tp1.ui.cliente.list.ListaClienteViewModel
import kotlinx.android.synthetic.main.form_oculos_fragment.*

class FormOculosFragment : Fragment() {

    private lateinit var viewModel: FormOculosViewModel
    private lateinit var viewModelCliente: ListaClienteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?

    {
        val view = inflater.inflate(R.layout.form_oculos_fragment, container, false)
        LogRegister.getInstance(requireContext()).escreverLog("Acessou: FormOculosFragment;")

        val appDatabase = AppDatabase.getInstance(requireContext().applicationContext)
        val oculosDao = appDatabase.oculosDao()
        val formOculosViewModelFactory = FormOculosViewModelFactory(oculosDao)

        viewModel = ViewModelProvider(this, formOculosViewModelFactory).get(FormOculosViewModel::class.java)
        viewModel.let {
            it.msg.observe(viewLifecycleOwner) { msg ->
                if(!msg.isNullOrBlank()){
                    Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
                }
            }
            it.status.observe(viewLifecycleOwner){status ->
                if(status)
                    limparFormulário()
                    //findNavController().popBackStack()

            }
        }

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
        viewModelCliente.atualizarListaClientes()
        //val view = inflater.inflate(R.layout.form_oculos_fragment, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(OculosUtil.oculosSelecionado != null)
            preencherFormulario(OculosUtil.oculosSelecionado!!)

        fabFormOculosSalvar.setOnClickListener{
            LogRegister.getInstance(requireContext()).escreverLog("Clicou: Botao para cadastrar oculos;")

            val marca = editTextOculosMarca.text.toString()
            val cor = editTextOculosCor.text.toString()
            val lente = editTextOculosLente.text.toString()
            val grau = editTextOculosGrau.text.toString()

            //editTextOculosMarca.isEnabled = false
            //editTextOculosCor.isEnabled = false
            //editTextOculosLente.isEnabled = false
            //editTextOculosGrau.isEnabled = false

            viewModel.salvarOculos(marca, cor, lente, grau)

        }

    }

    private fun preencherFormulario(oculos: Oculos){
        editTextOculosMarca.setText(oculos.marca)
        editTextOculosCor.setText(oculos.cor)
        editTextOculosLente.setText(oculos.lente)
        editTextOculosGrau.setText(oculos.grau)
    }

    private fun limparFormulário() {
        editTextOculosMarca.setText("")
        editTextOculosCor.setText("")
        editTextOculosLente.setText("")
        editTextOculosGrau.setText("")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(FormOculosViewModel::class.java)

        // TODO: Use the ViewModel
    }


}