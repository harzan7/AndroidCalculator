package com.harzan7.calculator

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class CalculatorViewModel: ViewModel() {

    private val _equationText = MutableStateFlow("")
    val equationText: StateFlow<String> = _equationText.asStateFlow()

    private val _resultText = MutableStateFlow("0")
    val resultText: StateFlow<String> = _resultText.asStateFlow()

    fun onButtonClick(btn: String) {
        Log.i("Clicked Button", btn)

        _equationText.value.let {
            when(btn) {
                "AC" -> {
                    _equationText.value = ""
                    _resultText.value = "0"
                    return
                }

                "C" -> {
                    if (it.isNotEmpty())
                        _equationText.value = it.substring(0, it.length - 1)
                    return
                }

                "=" -> {
                    _equationText.value = _resultText.value
                    return
                }

                else -> {
                    _equationText.value = it + btn
                }
            }

            // Calculate Result
            try {
                _resultText.value = calculateResult(_equationText.value)
                Log.i("Result", resultText.value)
            } catch (_: Exception) {}
        }
    }

    private fun calculateResult(equation: String): String {
        val context: Context = Context.enter()
        context.isInterpretedMode = true
        val scriptable: Scriptable = context.initStandardObjects()
        var finalResult = context.evaluateString(scriptable, equation, "Javascript", 1, null).toString()
        if (finalResult.endsWith(".0")) {
            finalResult = finalResult.replace(".0", "")
        }

        return finalResult
    }
}