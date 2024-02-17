package com.nathan.jettrivia.repository

import android.util.Log
import com.nathan.jettrivia.network.QuestionApi
import com.nathan.jettrivia.util.QuestionResponse
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val dataOrException = QuestionResponse()

    suspend fun getAllQuestions(): QuestionResponse {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
        } catch (exception: Exception) {
            dataOrException.exception = exception
            Log.d("Exc", "getAllQuestions: ${dataOrException.exception!!.localizedMessage}")
        } finally {
            dataOrException.loading = false
        }

        return dataOrException
    }
}