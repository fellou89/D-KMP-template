package us.fellou89.dkmptemplate.shared.viewmodel.screens

import us.fellou89.dkmptemplate.shared.viewmodel.ScreenIdentifier
import us.fellou89.dkmptemplate.shared.viewmodel.screens.Screen.*
import us.fellou89.dkmptemplate.shared.viewmodel.screens.countrieslist.CountriesListParams
import us.fellou89.dkmptemplate.shared.viewmodel.screens.countrieslist.CountriesListType.*


// CONFIGURATION SETTINGS

object navigationSettings {
    val homeScreen = Level1Navigation.AllCountries // the start screen should be specified here
    val saveLastLevel1Screen = true
    val alwaysQuitOnHomeScreen = true
}


// LEVEL 1 NAVIGATION OF THE APP

enum class Level1Navigation(val screenIdentifier: ScreenIdentifier, val rememberVerticalStack: Boolean = false) {
    AllCountries( ScreenIdentifier.get(CountriesList, CountriesListParams(listType = ALL)), true),
    FavoriteCountries( ScreenIdentifier.get(CountriesList, CountriesListParams(listType = FAVORITES)), true),
}