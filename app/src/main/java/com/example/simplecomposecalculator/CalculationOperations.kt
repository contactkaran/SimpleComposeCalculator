package com.example.simplecomposecalculator

open class CalculationOperations(val symbol: String) {
    object Plus : CalculationOperations("+")
    object Minus : CalculationOperations("-")
    object Multiply : CalculationOperations("*")
    object Divide : CalculationOperations("/")
}