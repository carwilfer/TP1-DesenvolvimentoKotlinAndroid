package com.carwilfer.carlos_ferreira_dr3_tp1.ui.cliente.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.carwilfer.carlos_ferreira_dr3_tp1.LogRegister
import com.carwilfer.carlos_ferreira_dr3_tp1.R
import kotlinx.android.synthetic.main.form_cliente_fragment.*
import kotlinx.android.synthetic.main.lista_cliente_fragment.*

class ListaClienteFragment : Fragment() {

    private lateinit var viewModel: ListaClienteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.lista_cliente_fragment, container, false)
        LogRegister.getInstance(requireContext()).escreverLog("Acessou: ListaClienteFragment;")
        viewModel = ViewModelProvider(this).get(ListaClienteViewModel::class.java)
        viewModel.clientes.observe(viewLifecycleOwner){
            listViewCliente.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                it
            )
        }

        viewModel.atualizarListaClientes()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fabFormCliente.setOnClickListener{
            findNavController().navigate(R.id.formClienteFragment)
        }
        fabConfigCliente.setOnClickListener{
            findNavController().navigate(R.id.configClienteFragment)
        }

    }
}