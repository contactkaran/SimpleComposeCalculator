package com.example.simplecomposecalculator

open class CalcClickActions {

    data class Number( val number: Int): CalcClickActions()
    object Clear: CalcClickActions()
    object Delete: CalcClickActions()
    object Decimal: CalcClickActions()
    object Calculate: CalcClickActions()
    data class Operation(val operation: CalculationOperations): CalcClickActions()

}