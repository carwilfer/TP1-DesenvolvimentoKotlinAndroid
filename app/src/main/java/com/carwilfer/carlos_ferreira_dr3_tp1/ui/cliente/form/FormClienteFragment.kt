package com.carwilfer.carlos_ferreira_dr3_tp1.ui.cliente.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.carwilfer.carlos_ferreira_dr3_tp1.database.ClienteUtil
import com.carwilfer.carlos_ferreira_dr3_tp1.LogRegister
import com.carwilfer.carlos_ferreira_dr3_tp1.R
import com.carwilfer.carlos_ferreira_dr3_tp1.database.AppDatabase
import com.carwilfer.carlos_ferreira_dr3_tp1.model.Cliente
import kotlinx.android.synthetic.main.form_cliente_fragment.*
import kotlinx.android.synthetic.main.form_oculos_fragment.*

class FormClienteFragment : Fragment() {

    private lateinit var viewModel: FormClienteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.form_cliente_fragment, container, false)
        LogRegister.getInstance(requireContext()).escreverLog("Acessou: FormClienteFragment;")

        val appDatabase = AppDatabase.getInstance(requireContext().applicationContext)
        val clienteDao = appDatabase.clienteDao()
        val formClienteViewModelFactory = FormClienteViewModelFactory(clienteDao)

        viewModel = ViewModelProvider(this, formClienteViewModelFactory).get(FormClienteViewModel::class.java)
        viewModel.let {
            it.msg.observe(viewLifecycleOwner){ msg ->
                if (!msg.isNullOrBlank()){
                    Toast.makeText(requireContext(), msg, Toast.LENGTH_LONG).show()
                }
            }
            it.status.observe(viewLifecycleOwner){status ->
                if(status)
                    limparFormulário()
                    //findNavController().popBackStack()

            }

        }
        //val view = inflater.inflate(R.layout.form_cliente_fragment, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(FormClienteViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(ClienteUtil.clienteSelecionado != null)
            preencherFormulario(ClienteUtil.clienteSelecionado!!)

        fabFormClienteSalvar.setOnClickListener{
            LogRegister.getInstance(requireContext()).escreverLog("Clicou: Botao para cadastrar clientes;")

            //capturar os dados inseridos
            val nome = editTextFormeClienteNome.text.toString()
            val cpf = editTextFormeClienteCPF.text.toString()

            //desabilitar os clics dos botoes

            //editTextFormeClienteNome.isEnabled = false
            //editTextFormeClienteNome.isEnabled = false


            //envia para a viewModel Persistir os dados
            viewModel.salvarCliente(nome, cpf)



        }
    }

    private fun preencherFormulario(cliente: Cliente){
        editTextOculosMarca.setText(cliente.nome)
        editTextOculosCor.setText(cliente.cpf)

    }

    private fun limparFormulário() {
        editTextFormeClienteNome.setText("")
        editTextFormeClienteCPF.setText("")
    }
}