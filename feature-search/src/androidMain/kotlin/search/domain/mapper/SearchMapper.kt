package search.domain.mapper

import com.codandotv.streamplayerapp.core_shared.Url
import search.data.model.ListSearchStreamResponse.SearchStreamResponse
import search.presentation.widgets.SearchStreamCardModel

fun SearchStreamResponse.toSearchStreamCardModel() = SearchStreamCardModel(
    id = id.toString(),
    title = title,
    url = "${Url.IMAGE_URL_SIZE_200}${posterPath}"
)
