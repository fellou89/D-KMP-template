package us.fellou89.dkmptemplate.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import us.fellou89.dkmptemplate.screens.countrydetail.CountryDetailScreen
import us.fellou89.dkmptemplate.screens.countrieslist.CountriesListScreen
import us.fellou89.dkmptemplate.screens.countrieslist.CountriesListTwoPaneDefaultDetail
import us.fellou89.dkmptemplate.shared.viewmodel.Navigation
import us.fellou89.dkmptemplate.shared.viewmodel.ScreenIdentifier
import us.fellou89.dkmptemplate.shared.viewmodel.ScreenParams
import us.fellou89.dkmptemplate.shared.viewmodel.screens.Screen
import us.fellou89.dkmptemplate.shared.viewmodel.screens.Screen.*
import us.fellou89.dkmptemplate.shared.viewmodel.screens.countrieslist.CountriesListState
import us.fellou89.dkmptemplate.shared.viewmodel.screens.countrieslist.selectFavorite
import us.fellou89.dkmptemplate.shared.viewmodel.screens.countrydetail.CountryDetailParams
import us.fellou89.dkmptemplate.shared.viewmodel.screens.countrydetail.CountryDetailState


@Composable
fun Navigation.ScreenPicker(
    screenIdentifier: ScreenIdentifier,
    navigate: (Screen, ScreenParams?) -> Unit
) {

    val state by stateProvider.getScreenStateFlow(screenIdentifier).collectAsState()

    when (screenIdentifier.screen) {

        CountriesList ->
            CountriesListScreen(
                countriesListState = state as CountriesListState,
                onListItemClick = { navigate(CountryDetail, CountryDetailParams(countryName = it)) },
                onFavoriteIconClick = { events.selectFavorite(countryName = it) },
            )

        CountryDetail ->
            CountryDetailScreen(
                countryDetailState = state as CountryDetailState
            )

    }

}



@Composable
fun Navigation.TwoPaneDefaultDetail(
    screenIdentifier: ScreenIdentifier
) {

    when (screenIdentifier.screen) {

        CountriesList ->
            CountriesListTwoPaneDefaultDetail()

        else -> Box{}
    }

}