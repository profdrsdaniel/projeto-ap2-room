package br.com.ulbra.exemplorecycler.data.datasources

import br.com.ulbra.exemplorecycler.data.database.ProductDao
import br.com.ulbra.exemplorecycler.data.database.ProductEntity
import javax.inject.Inject

class ProductDataSource @Inject constructor(private val productDao: ProductDao) {
    fun fetchAllProducts(): List<ProductEntity> = productDao.fetchAllProducts()
    suspend fun addProduct(productEntity: ProductEntity) = productDao.addProduct(productEntity)

    suspend fun deleteProduct(productName: String) = productDao.deleteProduct(productName)
}