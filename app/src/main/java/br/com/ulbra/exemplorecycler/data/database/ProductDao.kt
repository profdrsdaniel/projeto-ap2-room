package br.com.ulbra.exemplorecycler.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    fun fetchAllProducts(): List<ProductEntity>

    @Insert
    suspend fun addProduct(productEntity: ProductEntity)

    @Query("Delete from products where name = :productName")
    suspend fun deleteProduct(productName: String)

}