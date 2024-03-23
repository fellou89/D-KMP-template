package us.fellou89.dkmptemplate.screens.countrieslist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import us.fellou89.dkmptemplate.screens.LoadingScreen
import us.fellou89.dkmptemplate.shared.viewmodel.screens.countrieslist.CountriesListState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CountriesListScreen(
    countriesListState: CountriesListState,
    onListItemClick: (String) -> Unit,
    onFavoriteIconClick : (String) -> Unit,
) {
    if (countriesListState.isLoading) {

        LoadingScreen()

    } else {
        if (countriesListState.countriesListItems.isEmpty()) {
            Text(
                text = "empty list",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 30.dp).fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
        } else {
            LazyColumn {
                stickyHeader {
                    CountriesListHeader()
                }
                items(items = countriesListState.countriesListItems, itemContent = { item ->
                    CountriesListRow(
                        item = item,
                        favorite = countriesListState.favoriteCountries.containsKey(item.name),
                        onItemClick = { onListItemClick(item.name) },
                        onFavoriteIconClick = { onFavoriteIconClick(item.name) })
                })
            }
        }
    }

}