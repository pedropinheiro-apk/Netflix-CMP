package com.codandotv.streamplayerapp.feature_list_streams.list.domain.model

import androidx.annotation.DrawableRes
import org.jetbrains.compose.resources.StringResource

data class HighlightBanner(
    val name: String,
    val imageUrl: String,
    val contentType: StringResource,
    val contentTypeAsPlural: StringResource,
    val extraInfo: IconAndTextInfo,
    val leftButton: IconAndTextInfo,
    val centralButton: IconAndTextInfo,
    val rightButton: IconAndTextInfo
)

data class IconAndTextInfo(
    @DrawableRes val icon: Int,
    val text: StringResource
)