package br.com.ulbra.exemplorecycler.data.repositories

import br.com.ulbra.exemplorecycler.data.Product
import br.com.ulbra.exemplorecycler.data.database.mapperToProduct
import br.com.ulbra.exemplorecycler.data.datasources.ProductDataSource
import br.com.ulbra.exemplorecycler.data.mapperToEntity
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productDataSource: ProductDataSource) {
    fun fetchAllProducts(): List<Product> {
        return productDataSource
            .fetchAllProducts()
            .map { item -> item.mapperToProduct() }
    }

    suspend fun addProduct(product: Product) {
        productDataSource.addProduct(product.mapperToEntity())
    }

    suspend fun deleteProduct(product: Product) {
        productDataSource.deleteProduct(product.name)
    }
}