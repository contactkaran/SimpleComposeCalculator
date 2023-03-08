package com.example.simplecomposecalculator

data class CalcState (
    val number1: String = "",
    val number2: String = "",
    val operation: CalculationOperations?= null
){

}