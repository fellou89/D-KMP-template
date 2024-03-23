package us.fellou89.dkmptemplate.shared.viewmodel.screens.countrydetail

import us.fellou89.dkmptemplate.shared.datalayer.functions.getCountryInfo
import us.fellou89.dkmptemplate.shared.viewmodel.ScreenParams
import us.fellou89.dkmptemplate.shared.viewmodel.StateManager
import us.fellou89.dkmptemplate.shared.viewmodel.screens.ScreenInitSettings
import kotlinx.serialization.Serializable


// INIZIALIZATION settings for this screen
// to understand the initialization behaviour, read the comments in the ScreenInitSettings.kt file

@Serializable // Note: ScreenParams should always be set as Serializable
data class CountryDetailParams(val countryName: String) : ScreenParams

fun StateManager.initCountryDetail(params: CountryDetailParams) = ScreenInitSettings (
    title = params.countryName,
    initState = { CountryDetailState(isLoading = true) },
    callOnInit = {
        val countryInfo = dataRepository.getCountryInfo(params.countryName)
        // update state, after retrieving data from the repository
        updateScreen(CountryDetailState::class) {
            it.copy(
                isLoading = false,
                countryInfo = countryInfo,
            )
        }
    },
)