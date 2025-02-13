package com.codandotv.streamplayerapp.feature_list_streams.list.presentation.widgets

import androidx.compose.runtime.Composable
import com.codandotv.streamplayerapp.core_shared_ui.theme.ThemePreviews
import com.codandotv.streamplayerapp.feature_list_streams.list.domain.model.IconAndTextInfo
import org.jetbrains.compose.resources.stringResource
import streamplayerapp_kmp.core_shared_ui.generated.resources.Res
import streamplayerapp_kmp.core_shared_ui.generated.resources.app_name
import streamplayerapp_kmp.core_shared_ui.generated.resources.ic_add
import streamplayerapp_kmp.core_shared_ui.generated.resources.ic_info
import streamplayerapp_kmp.core_shared_ui.generated.resources.ic_play
import streamplayerapp_kmp.feature_list_streams.generated.resources.ic_top_10
import streamplayerapp_kmp.feature_list_streams.generated.resources.list_highlight_banner_add
import streamplayerapp_kmp.feature_list_streams.generated.resources.list_highlight_banner_info
import streamplayerapp_kmp.feature_list_streams.generated.resources.list_highlight_banner_watch

@ThemePreviews
@Composable
fun HighlightBannerPreview() {
    HighlightBanner(
        data = com.codandotv.streamplayerapp.feature_list_streams.list.domain.model.HighlightBanner(
            name = stringResource(Res.string.app_name),
            imageUrl = String(),
            contentType = com.codandotv.streamplayerapp.feature_list_streams.core.ContentType.getContentName(
                com.codandotv.streamplayerapp.feature_list_streams.core.ContentType.SHOW
            ),
            contentTypeAsPlural = com.codandotv.streamplayerapp.feature_list_streams.core.ContentType.getContentNameAsPlural(
                com.codandotv.streamplayerapp.feature_list_streams.core.ContentType.SHOW
            ),
            extraInfo = IconAndTextInfo(
                streamplayerapp_kmp.feature_list_streams.generated.resources.Res.drawable.ic_top_10,
                com.codandotv.streamplayerapp.feature_list_streams.core.ContentType.getContentName(
                    com.codandotv.streamplayerapp.feature_list_streams.core.ContentType.SHOW
                )
            ),
            leftButton = IconAndTextInfo(
                Res.drawable.ic_add,
                streamplayerapp_kmp.feature_list_streams.generated.resources.Res.string.list_highlight_banner_add
            ),
            centralButton = IconAndTextInfo(
                Res.drawable.ic_play,
                streamplayerapp_kmp.feature_list_streams.generated.resources.Res.string.list_highlight_banner_watch
            ),
            rightButton = IconAndTextInfo(
                Res.drawable.ic_info,
                streamplayerapp_kmp.feature_list_streams.generated.resources.Res.string.list_highlight_banner_info
            ),
        )
    )
}
