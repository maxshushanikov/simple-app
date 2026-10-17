package org.simpleapp.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AppInfo(
    @param:StringRes @get:StringRes val nameRes: Int,
    @param:StringRes @get:StringRes val descriptionRes: Int,
    @param:StringRes @get:StringRes val categoryRes: Int,
    @param:DrawableRes @get:DrawableRes val iconRes: Int,
    @param:ColorRes @get:ColorRes val iconBackgroundRes: Int
)
