package com.joohnq.doctorappointment.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

object TextStyles {
    @Composable
    fun H2Bold()= TextStyle(
        fontFamily = FontFamily.OpenSans.Bold(),
        fontSize = 24.sp
    )

    @Composable
    fun BodyMedium()= TextStyle(
        fontFamily = FontFamily.OpenSans.Medium(),
        fontSize = 16.sp
    )

    @Composable
    fun BodyRegular()= TextStyle(
        fontFamily = FontFamily.OpenSans.Regular(),
        fontSize = 16.sp
    )

    @Composable
    fun Body2Regular()= TextStyle(
        fontFamily = FontFamily.OpenSans.Regular(),
        fontSize = 14.sp
    )

    @Composable
    fun Button()= TextStyle(
        fontFamily = FontFamily.OpenSans.Bold(),
        fontSize = 16.sp
    )
}