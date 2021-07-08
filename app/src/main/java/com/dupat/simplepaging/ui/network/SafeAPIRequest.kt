package com.dupat.simplepaging.ui.network

import com.dupat.simplepaging.ui.model.ErrorModel
import com.google.gson.Gson
import retrofit2.Response
import java.io.IOException
import java.lang.Exception


abstract class SafeAPIRequest {
    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>) : T{

        val response = call.invoke()

        if(response.isSuccessful){
            return response.body()!!
        }
        else {
            val gson = Gson()
            val error = gson.fromJson(response.errorBody()?.string(), ErrorModel::class.java)
            val message = StringBuilder()

            error?.let{
                try{
                    message.append(error.status_message)
                }catch(e: Exception){
                    message.append(e.message)
                }
            }

            throw ApiException(message.toString())
        }
    }
}


class ApiException(message: String): IOException(message)