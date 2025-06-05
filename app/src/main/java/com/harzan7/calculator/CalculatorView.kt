package com.harzan7.calculator

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harzan7.calculator.ui.theme.CalculatorTheme
import com.harzan7.calculator.ui.theme.clearButton
import com.harzan7.calculator.ui.theme.equalsButton
import com.harzan7.calculator.ui.theme.numberButton
import com.harzan7.calculator.ui.theme.operationButton

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
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = "0",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "0",
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onBackground,
            maxLines = 2,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.padding(8.dp)
        ) {
            items(buttonList) {
                CalculatorButton(
                    btn = it,
                    onClick = {
                        //TODO: viewModel.onButtonClick
                    }
                )
            }
        }

    }
}

@Composable
fun CalculatorButton(btn: String, onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .size(80.dp),
        shape = CircleShape,
        containerColor = getButtonColor(btn),
        contentColor = getButtonTextColor(btn),
    ) {
        Text(
            text = btn,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun getButtonColor(btn: String): Color {
    return when (btn) {
        "C", "AC" -> MaterialTheme.colorScheme.clearButton
        "÷", "×", "+", "−" -> MaterialTheme.colorScheme.operationButton
        "=" -> MaterialTheme.colorScheme.equalsButton
        else -> MaterialTheme.colorScheme.numberButton
    }
}

@Composable
fun getButtonTextColor(btn: String): Color {
    return when (btn) {
        "C", "AC" -> MaterialTheme.colorScheme.onError
        "÷", "×", "+", "−" -> MaterialTheme.colorScheme.onSecondary
        "=" -> MaterialTheme.colorScheme.onTertiary
        else -> MaterialTheme.colorScheme.onPrimary
    }
}

@Preview(name = "Light Mode", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun CalculatorAppPreview() {
    CalculatorApp()
}
