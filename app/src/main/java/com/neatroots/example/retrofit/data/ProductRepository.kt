package com.neatroots.example.retrofit.data

import com.neatroots.example.retrofit.data.Model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import com.neatroots.example.retrofit.Result

class ProductRepository(
    private val apiService: ApiService
) {
    suspend fun getProducts(): Flow<Result<List<Product>>> {
        return flow {
            val productResponse = try {
                apiService.getPrducts()
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(message = "Failed tp fetch products"))
                return@flow
            }
            emit(Result.Success(productResponse.products))
        }

    }

}