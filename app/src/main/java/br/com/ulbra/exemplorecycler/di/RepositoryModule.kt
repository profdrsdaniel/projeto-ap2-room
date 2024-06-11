package br.com.ulbra.exemplorecycler.di

import br.com.ulbra.exemplorecycler.data.database.ProductDao
import br.com.ulbra.exemplorecycler.data.datasources.ProductDataSource
import br.com.ulbra.exemplorecycler.data.repositories.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesProductRepository(productDataSource: ProductDataSource): ProductRepository {
        return ProductRepository(productDataSource)
    }
}