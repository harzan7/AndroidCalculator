package com.harzan7.calculator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.harzan7.calculator.ui.theme.CalculatorTheme

val buttonList = listOf(
    "C", "(", ")", "÷",
    "7", "8", "9", "×",
    "4", "5", "6", "+",
    "1", "2", "3", "−",
    "AC", "0", "•", "="
)

@Composable
fun CalculatorApp() {
    CalculatorTheme {
        CalculatorScreen()
    }
}

@Composable
fun CalculatorScreen(
    // TODO: viewModel
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        innerPadding ->
        CalculatorContent(
            modifier = Modifier.padding(innerPadding),
            // TODO: viewModel
        )

    }
}

@Composable
fun CalculatorContent(
    modifier: Modifier = Modifier,
    // TODO: viewModel
) {}
