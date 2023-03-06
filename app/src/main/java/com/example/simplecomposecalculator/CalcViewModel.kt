package com.example.simplecomposecalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcViewModel : ViewModel() {
    //changes state and updates the UI
    // state is not lost in change orientation
    var state by mutableStateOf(CalcState())
        private set
}