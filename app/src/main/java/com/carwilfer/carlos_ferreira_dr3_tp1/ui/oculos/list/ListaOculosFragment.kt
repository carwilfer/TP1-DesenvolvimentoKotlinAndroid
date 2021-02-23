package com.carwilfer.carlos_ferreira_dr3_tp1.ui.oculos.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.carwilfer.carlos_ferreira_dr3_tp1.LogRegister
import com.carwilfer.carlos_ferreira_dr3_tp1.database.OculosUtil
import com.carwilfer.carlos_ferreira_dr3_tp1.R
import com.carwilfer.carlos_ferreira_dr3_tp1.database.AppDatabase
import kotlinx.android.synthetic.main.lista_oculos_fragment.*

class ListaOculosFragment : Fragment() {
    private lateinit var listOculosViewModel: ListaOculosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lista_oculos_fragment, container, false)
        LogRegister.getInstance(requireContext()).escreverLog("Acessou: ListaOculosFragment;")
        //val appDatabase = AppDatabase.getInstance(requireContext().applicationContext)

        val appDatabase = AppDatabase.getInstance(requireContext().applicationContext) //abre conecxão com o appdatabase através do getInstance
        val oculosDao = appDatabase.oculosDao() //é chamado pra poder passar pra viewModel
        val listOculosViewModelFactory = ListOculosViewModelFactory(oculosDao) //necessario para poder passar para o factory

        listOculosViewModel = ViewModelProvider(this, listOculosViewModelFactory).get(ListaOculosViewModel::class.java)

        listOculosViewModel.oculos.observe(viewLifecycleOwner){
            listViewOculos.adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                it
            )
            listViewOculos.setOnItemClickListener{ //para clicar em qualquer um item da lista
                parent, view, position, id ->
                val oculos = it.get(position)
                OculosUtil.oculosSelecionado = oculos
                findNavController().navigate(R.id.formOculosFragment)

                //Toast.makeText(requireContext(), "${oculos.id}: ${oculos.marca}", Toast.LENGTH_LONG).show()
            }
        }
        listOculosViewModel.atualizarListaOculos()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fabFormOculos.setOnClickListener{
            OculosUtil.oculosSelecionado = null
            findNavController().navigate(R.id.formOculosFragment)
        }
        fabConfigOculos.setOnClickListener{
            findNavController().navigate(R.id.configOculosFragment)
        }

    }

}