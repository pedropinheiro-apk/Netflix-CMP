package com.codandotv.streamplayerapp.core_shared_ui.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.codandotv.streamplayerapp.core_shared.Url.IMAGE_URL_SIZE_300

@Preview
@Composable
fun StreamsCardPreview() {
    StreamsCard(
        StreamsCardContent(
            url = "${IMAGE_URL_SIZE_300}evgwd37VHBJhXvSr88Mrx5riFil.jpg",
            contentDescription = "Test 1",
            id = "",
        )
    )
}