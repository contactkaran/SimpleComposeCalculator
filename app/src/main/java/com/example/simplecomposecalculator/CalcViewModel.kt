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

    fun onAction(action: CalcClickActions) {
        when (action) {
            is CalcClickActions.Number -> enterNumber(action.number)
            is CalcClickActions.Decimal -> enterDecimal()
            is CalcClickActions.Clear -> state = CalcState()
            is CalcClickActions.Operation -> enterOperation(action.operation)
            is CalcClickActions.Calculate -> performCalculation()
            is CalcClickActions.Delete -> performDeletion()
        }

    }

    private fun performDeletion() {
        when {
            //removing the last char from states number2 and 1
            state.number2.isNotBlank() -> state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculationOperations.Plus -> number1 + number2
                is CalculationOperations.Minus -> number1 - number2
                is CalculationOperations.Multiply -> number1 * number2
                is CalculationOperations.Divide -> number1 / number2
                null -> return
                else -> {Unit}
            }
            state = state.copy(
                number1 = result.toString().take(12),
                number2 = "",
                operation = null
            )
        }
    }

    private fun enterOperation(operation: CalculationOperations) {
        //checking if user clicked on operation before entering any value
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
            //creating copy of the state and changing the operation, rest remaining the same
        }
    }

    private fun enterDecimal() {
        //first check if there is any number entered before the decimal
        //second check if the already entered number does not have a decimal
        //check if first number is not a blank
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {

            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        //now performing a check on the second number while inserting a decimal
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {

            state = state.copy(
                number1 = state.number2 + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        //entering a number into expression
        //checking if anything was entered
        //if no operator is entered, the entered number is assigned to number1 variable
        if (state.operation == null) {
            //checking if number entered is too long
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if(state.number2.length >= MAX_NUM_LENGTH){
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}