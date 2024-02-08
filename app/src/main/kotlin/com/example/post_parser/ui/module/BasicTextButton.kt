package com.example.post_parser.ui.module

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.post_parser.ui.theme.ItimTypography
import com.example.post_parser.ui.theme.Lilac

@Composable
fun BasicTextButton(
  text: String,
  onClickAction: () -> Unit,
  backgroundColor: Color = Lilac,
) {
  ElevatedButton(
    onClick = onClickAction,
    modifier = Modifier.height(40.dp),
    shape = RoundedCornerShape(12.dp),
    elevation = ButtonDefaults.buttonElevation(12.dp),
    contentPadding = PaddingValues(horizontal = 10.dp),
    colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
  ) {
    Text(text = text, style = ItimTypography.bodyLarge)
  }
}
