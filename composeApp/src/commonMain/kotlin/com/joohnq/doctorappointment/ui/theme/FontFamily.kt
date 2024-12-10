package com.joohnq.doctorappointment.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import doctorappointment.composeapp.generated.resources.Res
import doctorappointment.composeapp.generated.resources.open_sans_bold
import doctorappointment.composeapp.generated.resources.open_sans_light
import doctorappointment.composeapp.generated.resources.open_sans_medium
import doctorappointment.composeapp.generated.resources.open_sans_regular
import doctorappointment.composeapp.generated.resources.open_sans_semi_bold
import org.jetbrains.compose.resources.Font

object FontFamily {
    object OpenSans {
        @Composable
        fun Bold() = FontFamily(Font(Res.font.open_sans_bold, FontWeight.Bold, FontStyle.Normal))

        @Composable
        fun SemiBold() =
            FontFamily(Font(Res.font.open_sans_semi_bold, FontWeight.SemiBold, FontStyle.Normal))

        @Composable
        fun Medium() =
            FontFamily(Font(Res.font.open_sans_medium, FontWeight.Medium, FontStyle.Normal))

        @Composable
        fun Regular() =
            FontFamily(Font(Res.font.open_sans_regular, FontWeight.Normal, FontStyle.Normal))

        @Composable
        fun Light() = FontFamily(Font(Res.font.open_sans_light, FontWeight.Light, FontStyle.Normal))
    }
}