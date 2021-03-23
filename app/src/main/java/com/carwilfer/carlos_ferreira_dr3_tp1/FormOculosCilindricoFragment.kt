package com.carwilfer.carlos_ferreira_dr3_tp1

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FormOculosCilindricoFragment : Fragment() {

    companion object {
        fun newInstance() = FormOculosCilindricoFragment()
    }

    private lateinit var viewModel: FormOculosCilindricoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_oculos_cilindrico_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormOculosCilindricoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}