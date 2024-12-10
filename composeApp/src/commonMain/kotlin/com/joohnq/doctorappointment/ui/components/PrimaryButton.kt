package com.joohnq.doctorappointment.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joohnq.doctorappointment.ui.theme.Colors
import com.joohnq.doctorappointment.ui.theme.TextStyles

@Composable
fun PrimaryButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(56.dp),
        shape = CircleShape,
        colors = ButtonColors(
            containerColor = Colors.Primary,
            disabledContainerColor = Colors.Gray3,
            contentColor = Colors.White,
            disabledContentColor = Colors.Gray4
        )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = text, style = TextStyles.Button())
        }
    }
}