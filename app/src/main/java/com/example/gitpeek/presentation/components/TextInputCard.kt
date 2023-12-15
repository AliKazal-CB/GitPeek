package com.example.gitpeek.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gitpeek.R

/**
 * A Composable view for a search text box
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputCard(
    inputValue: String,
    onValueChange: (String) -> Unit,
    onSearchClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            onValueChange = onValueChange,
            label = { Text(text = stringResource(id = R.string.text_input_card_hint)) },
            modifier = Modifier.weight(1f),
            value = inputValue,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedLabelColor = colorResource(R.color.pink),
                focusedIndicatorColor = colorResource(R.color.pink),
                cursorColor = colorResource(R.color.pink)
            )
        )
        Button(
            shape = RoundedCornerShape(10),
            modifier = Modifier.padding(start = 10.dp),
            contentPadding = PaddingValues(start = 15.dp, end = 15.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.LightGray
            ),
            onClick = onSearchClick
        ) {
            Text(
                style = MaterialTheme.typography.titleMedium,
                text = stringResource(id = R.string.text_input_card_button).uppercase()
            )
        }
    }
}