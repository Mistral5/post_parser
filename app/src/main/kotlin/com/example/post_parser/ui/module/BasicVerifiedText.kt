package com.example.post_parser.ui.module

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.post_parser.ui.theme.ItimTypography
import com.example.post_parser.ui.theme.Lilac

@Composable
fun BasicVerifiedText(
  key: String,
  value: String?,
  style: TextStyle = ItimTypography.bodyMedium,
  color: Color = Lilac,
) {
  value?.let {
    Text(
      modifier = Modifier.fillMaxWidth(),
      text = "$key: $it",
      style = style,
      color = color,
    )
  }
}
