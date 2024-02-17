package com.nathan.jettrivia.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nathan.jettrivia.data.DataOrException
import com.nathan.jettrivia.repository.QuestionRepository
import com.nathan.jettrivia.util.QuestionResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val repository: QuestionRepository): ViewModel() {

    val data: MutableState<QuestionResponse> = mutableStateOf(
                DataOrException(null, null, null)
            )

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions()
        }
    }
}