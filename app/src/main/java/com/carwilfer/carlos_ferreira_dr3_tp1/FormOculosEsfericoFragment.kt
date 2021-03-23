package com.carwilfer.carlos_ferreira_dr3_tp1

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FormOculosEsfericoFragment : Fragment() {

    companion object {
        fun newInstance() = FormOculosEsfericoFragment()
    }

    private lateinit var viewModel: FormOculosEsfericoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_oculos_esferico_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormOculosEsfericoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}