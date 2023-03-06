package com.example.simplecomposecalculator

import android.hardware.lights.Light
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecomposecalculator.ui.theme.GenericButton
import com.example.simplecomposecalculator.ui.theme.LightGray
import com.example.simplecomposecalculator.ui.theme.Orange
import com.example.simplecomposecalculator.ui.theme.genericButton

@Composable
fun CalculatorScreen(
    state: CalcState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 5.dp,
    onAction: (CalcClickActions) -> Unit
) {
    //Box for the calculator body
    //followed by column which will house display output screen and button rows
    Box(modifier = modifier) {
        //first box for calculator display screen
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter), verticalArrangement = Arrangement.spacedBy(buttonSpacing)) {

            Text(text = state.number1 + (state.operation ?: "") + state.number2,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            fontWeight = FontWeight.Light,
            fontSize = 80.sp,
            color = Color.White,
                maxLines = 2
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                //adding buttons in first row
                GenericButton(buttonText = "AC",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick =  {
                        onAction(CalcClickActions.Clear)
                    }
                )
                GenericButton(buttonText = "Del",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick =  {
                        onAction(CalcClickActions.Delete)
                    }
                )
                GenericButton(buttonText = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick =  {
                        onAction(CalcClickActions.Operation(CalculationOperations.Divide))
                    }
                )
            }


            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                //adding buttons in first row
                GenericButton(buttonText = "7",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick =  {
                        onAction(CalcClickActions.Number(7))
                    }
                )
                GenericButton(buttonText = "8",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick =  {
                        onAction(CalcClickActions.Number(8))
                    }
                )
                GenericButton(buttonText = "9",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick =  {
                        onAction(CalcClickActions.Number(9))
                    }
                )
                GenericButton(buttonText = "*",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick =  {
                        onAction(CalcClickActions.Operation(CalculationOperations.Multiply))
                    }
                )
            }


            



        }
        
    }
}