package com.nmt.kmpcore.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nmt.kmpcore.coreLibrary.commonMain.Res
import com.nmt.kmpcore.coreLibrary.commonMain.poppins_bold
import com.nmt.kmpcore.coreLibrary.commonMain.poppins_light
import com.nmt.kmpcore.coreLibrary.commonMain.poppins_semibold
import org.jetbrains.compose.resources.Font

@Composable
fun getTypography(
    displayLarge: TextStyle? = null,
    displayMedium: TextStyle? = null,
    displaySmall: TextStyle? = null,
    headlineLarge: TextStyle? = null,
    headlineMedium: TextStyle? = null,
    headlineSmall: TextStyle? = null,
    titleLarge: TextStyle? = null,
    titleMedium: TextStyle? = null,
    titleSmall: TextStyle? = null,
    bodyLarge: TextStyle? = null,
    bodyMedium: TextStyle? = null,
    bodySmall: TextStyle? = null,
    labelLarge: TextStyle? = null,
    labelMedium: TextStyle? = null,
    labelSmall: TextStyle? = null,
): Typography {
    val poppinsLightFontFamily = FontFamily(
        Font(
            Res.font.poppins_light,
            FontWeight.Light,
            FontStyle.Normal
        )
    )

    val poppinsSemiBoldFontFamily = FontFamily(
        Font(
            Res.font.poppins_semibold,
            FontWeight.SemiBold,
            FontStyle.Normal
        )
    )

    val poppinsBoldFontFamily = FontFamily(
        Font(
            Res.font.poppins_bold,
            FontWeight.Bold,
            FontStyle.Normal
        )
    )
    return Typography(
        bodyLarge = bodyLarge ?: TextStyle(
            fontFamily = poppinsSemiBoldFontFamily,
            fontSize = 22.sp,
            lineHeight = 32.sp,
            letterSpacing = 0.5.sp,
        ),
        titleLarge = titleLarge ?: TextStyle(
            fontFamily = poppinsBoldFontFamily,
            fontSize = 28.sp,
            lineHeight = 38.sp,
            letterSpacing = 0.sp,
        ),
        bodyMedium = bodyMedium ?: TextStyle(
            fontFamily = poppinsLightFontFamily,
            fontSize = 14.sp,
            lineHeight = 22.sp,
            letterSpacing = 0.5.sp,
        ),
        displayLarge = displayLarge ?: Typography().displayLarge,
        displayMedium = displayMedium ?: Typography().displayLarge,
        displaySmall = displaySmall ?: Typography().displayLarge,
        headlineLarge = headlineLarge ?: Typography().displayLarge,
        headlineMedium = headlineMedium ?: Typography().displayLarge,
        headlineSmall = headlineSmall ?: Typography().displayLarge,
        titleMedium = titleMedium ?: Typography().displayLarge,
        titleSmall = titleSmall ?: Typography().displayLarge,
        bodySmall = bodySmall ?: Typography().displayLarge,
        labelLarge = labelLarge ?: Typography().displayLarge,
        labelMedium = labelMedium ?: Typography().displayLarge,
        labelSmall = labelSmall ?: Typography().displayLarge,
    )
}
