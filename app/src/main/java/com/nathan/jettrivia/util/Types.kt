package com.nathan.jettrivia.util

import com.nathan.jettrivia.data.DataOrException
import com.nathan.jettrivia.model.QuestionItem

typealias QuestionResponse = DataOrException<ArrayList<QuestionItem>,
        Boolean, Exception>