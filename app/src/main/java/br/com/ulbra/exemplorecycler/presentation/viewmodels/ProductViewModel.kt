package br.com.ulbra.exemplorecycler.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ulbra.exemplorecycler.commons.utils.Resultado
import br.com.ulbra.exemplorecycler.data.Product
import br.com.ulbra.exemplorecycler.data.repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewmodel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    private val _products = MutableLiveData<Resultado<List<Product>>>()
    val products = _products

    fun fetchProducts() {
        _products.postValue(Resultado.Loading)

        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)

            try {
                val result = productRepository.fetchAllProducts()
                _products.postValue(Resultado.Success(data = result))
            } catch (e: Exception) {
                _products.postValue(Resultado.Error(e))
            }
        }
    }

    fun addProduct(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        productRepository.addProduct(product)
    }

    fun removeProduct(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        productRepository.deleteProduct(product)
        fetchProducts()
    }
}