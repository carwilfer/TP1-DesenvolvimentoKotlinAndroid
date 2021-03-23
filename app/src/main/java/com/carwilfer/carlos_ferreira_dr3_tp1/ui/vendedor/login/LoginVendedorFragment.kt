package com.carwilfer.carlos_ferreira_dr3_tp1.ui.vendedor.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.carwilfer.carlos_ferreira_dr3_tp1.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login_vendedor_fragment.*

class LoginVendedorFragment : Fragment() {

    private lateinit var viewModelLoginVendedor: LoginVendedorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModelLoginVendedor = ViewModelProvider(this).get(LoginVendedorViewModel::class.java)
        viewModelLoginVendedor.status.observe(viewLifecycleOwner, {
            if (it){
                requireActivity().bottomNavigationView.visibility = View.VISIBLE
                findNavController().navigate(R.id.listaOculosFragment)
            }
        })
        viewModelLoginVendedor.msg.observe(viewLifecycleOwner, {
            if (!it.isNullOrBlank())
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        })
        return inflater.inflate(R.layout.login_vendedor_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnFormLoginAcessarVendedor.setOnClickListener {
            val email = editTextFormLoginEmailVendedor.text.toString()
            val senha = editTextFormLoginSenhaVendedor.text.toString()
            viewModelLoginVendedor.verificarCredenciais(email, senha)
        }

        btnFormLoginCadastroVendedor.setOnClickListener {
            findNavController().navigate(R.id.cadastroVendedorFragment)
        }
    }
}