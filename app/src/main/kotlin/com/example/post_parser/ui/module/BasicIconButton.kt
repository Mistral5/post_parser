package com.example.post_parser.ui.module

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.post_parser.ui.theme.Lilac

@Composable
fun BasicIconButton(
  imageVector: ImageVector,
  onClickAction: () -> Unit,
  contentDescription: String? = null,
  backgroundColor: Color = Lilac,
) {
  ElevatedButton(
    onClick = onClickAction,
    modifier = Modifier.size(40.dp),
    shape = RoundedCornerShape(12.dp),
    elevation = ButtonDefaults.buttonElevation(12.dp),
    contentPadding = PaddingValues(0.dp),
    colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
  ) {
    Icon(
      imageVector,
      contentDescription = contentDescription,
      tint = Color.White,
    )
  }
}
