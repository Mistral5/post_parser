package com.example.post_parser.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.post_parser.R

val ItimFamily =
  FontFamily(
    Font(R.font.itim_regular, FontWeight.Normal),
  )

val ItimTypography =
  Typography(
    titleLarge =
      TextStyle(
        fontFamily = ItimFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        color = Color.White,
      ),
    titleMedium =
      TextStyle(
        fontFamily = ItimFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Color.White,
      ),
    titleSmall =
      TextStyle(
        fontFamily = ItimFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        color = Color.White,
      ),
    bodyLarge =
      TextStyle(
        fontFamily = ItimFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
//    lineHeight = 20.sp,
//    letterSpacing = 0.5.sp,
        color = Color.White,
      ),
    bodyMedium =
      TextStyle(
        fontFamily = ItimFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        letterSpacing = 0.5.sp,
        color = Color.White,
      ),
    bodySmall =
      TextStyle(
        fontFamily = ItimFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color.White,
      ),
  )
