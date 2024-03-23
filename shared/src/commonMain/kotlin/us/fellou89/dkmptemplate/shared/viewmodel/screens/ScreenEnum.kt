package us.fellou89.dkmptemplate.shared.viewmodel.screens

import us.fellou89.dkmptemplate.shared.viewmodel.ScreenIdentifier
import us.fellou89.dkmptemplate.shared.viewmodel.StateManager
import us.fellou89.dkmptemplate.shared.viewmodel.screens.countrieslist.initCountriesList
import us.fellou89.dkmptemplate.shared.viewmodel.screens.countrydetail.initCountryDetail


// DEFINITION OF ALL SCREENS IN THE APP

enum class Screen(
    val asString: String,
    val navigationLevel : Int = 1,
    val initSettings: StateManager.(ScreenIdentifier) -> ScreenInitSettings,
) {
    CountriesList("countrieslist", 1, { initCountriesList(it.params()) }),
    CountryDetail("country", 2, { initCountryDetail(it.params()) })
}