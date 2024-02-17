package com.nathan.jettrivia.screens

import androidx.compose.runtime.Composable
import com.nathan.jettrivia.component.Questions

@Composable
fun TriviaHome(viewModel: QuestionsViewModel) {
    Questions(viewModel)
}