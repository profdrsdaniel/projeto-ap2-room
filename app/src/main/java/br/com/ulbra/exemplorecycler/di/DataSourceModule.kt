package br.com.ulbra.exemplorecycler.di

import br.com.ulbra.exemplorecycler.data.database.ProductDao
import br.com.ulbra.exemplorecycler.data.datasources.ProductDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesProductDataSource(productDao: ProductDao): ProductDataSource {
        return ProductDataSource(productDao)
    }
}