package com.carwilfer.carlos_ferreira_dr3_tp1.ui.oculos.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.carwilfer.carlos_ferreira_dr3_tp1.R
import kotlinx.android.synthetic.main.lista_oculos_fragment.*

class ListaOculosFragment : Fragment() {
    private lateinit var viewModel: ListaOculosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lista_oculos_fragment, container, false)
        //LogRegister.getInstance(requireContext()).escreverLog("Acessou: ListaOculosFragment")
        //val appDatabase = AppDatabase.getInstance(requireContext().applicationContext)

        viewModel = ViewModelProvider(this).get(ListaOculosViewModel::class.java)
        viewModel.oculos.observe(viewLifecycleOwner){
            listViewOculos.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                it
            )
        }
        viewModel.atualizarListaOculos()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fabFormOculos.setOnClickListener{
            findNavController().navigate(R.id.formOculosFragment)
        }

    }

}