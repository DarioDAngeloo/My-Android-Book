package com.example.myandroidbook.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val DayBg = Color(0xFFF0DBC7)
val NightBg = Color(0xFF2E3043)

val DayTitle = Color(0xFF997B66)
val NightTitle = Color(0xFFF9A826)

val DayDesc = Color(0xFF997B66)
val NightDesc = Color(0xFFD7D7D7)

val DayBtn = Color(0xFF997B66)
val NightBtn = Color(0xFFF9A826)

val DayBtnTxt = Color(0xFFF0EAD2)
val NightBtnTxt = Color(0xFF3D405B)

val pageDay = Color(0xFF997B66)
val pageNight = Color(0xFFF9A826)

val pageInactiveDay = Color(0xFFFDFAF8)
val pageInactiveNight = Color(0xFFD9D9D9)


val Colors.welcomeScreens
    get() = if (isLight) DayBg else NightBg

val Colors.welcomeScreensTitles
    get() = if (isLight) DayTitle else NightTitle

val Colors.welcomeScreensDesc
    get() = if (isLight) DayDesc else NightDesc

val Colors.welcomeScreensBtn
    get() = if (isLight) DayBtn else NightBtn

val Colors.welcomeScreensBtnTxt
    get() = if (isLight) DayBtnTxt else NightBtnTxt

val Colors.welcomeScreensPageActive
    get() = if (isLight) pageDay else pageNight

val Colors.welcomeScreensPageInactive
    get() = if (isLight) pageInactiveDay else pageInactiveNight


//top bar
val topBarTxtDay = Color(0xFF997B66)
val topBarTxtNight = Color(0xFFB8C8D3)
val Colors.homeTopBarTxt
    get() = if (isLight) topBarTxtDay else topBarTxtNight

val topBarDay = Color(0xFFF0DBC7)
val topBarNight = Color(0xFF2E3043)
val Colors.homeTopBar
    get() = if (isLight) topBarDay else topBarNight

val topIcon = Color(0xFF997B66)
val topIconNight = Color(0xFFB8C8D3)
val Colors.homeTopIcon
    get() = if (isLight) topIcon else topIconNight

//Star color
val startColor = Color(0xFFFF9800)


