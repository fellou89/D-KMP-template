package us.fellou89.dkmptemplate.shared.viewmodel.screens.countrieslist

import us.fellou89.dkmptemplate.shared.datalayer.functions.getFavoriteCountriesMap
import us.fellou89.dkmptemplate.shared.viewmodel.Events


/********** EVENT functions, called directly by the UI layer **********/

fun Events.selectFavorite(countryName: String) = screenCoroutine {
    val favorites = dataRepository.getFavoriteCountriesMap(alsoToggleCountry = countryName)
    // update state with new favorites map, after toggling the value for the specified country
    stateManager.updateScreen(CountriesListState::class) {
        it.copy(favoriteCountries = favorites)
    }
}
