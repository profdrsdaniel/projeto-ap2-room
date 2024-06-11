package br.com.ulbra.exemplorecycler.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.ulbra.exemplorecycler.R
import br.com.ulbra.exemplorecycler.configureToolbar
import br.com.ulbra.exemplorecycler.data.Product
import br.com.ulbra.exemplorecycler.databinding.FragmentAdicionarBinding
import br.com.ulbra.exemplorecycler.presentation.viewmodels.ProductViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdicionarFragment : Fragment() {
    private lateinit var binding: FragmentAdicionarBinding
    private lateinit var productViewModel: ProductViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdicionarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productViewModel = ViewModelProvider(this)[ProductViewmodel::class.java]

        binding.btnSalvar.setOnClickListener {
            val product = Product(
                name = binding.inputName.text.toString(),
                price = binding.inputPrice.text.toString(),
                urlImage = binding.inputUrlProduto.text.toString()
            )

            productViewModel.addProduct(product)

            findNavController().navigate(R.id.action_adicionarFragment_to_homeFragment)
        }
    }

}