package us.fellou89.dkmptemplate.shared.datalayer.sources.localsettings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.long
import com.russhwolf.settings.string
import us.fellou89.dkmptemplate.shared.viewmodel.screens.Level1Navigation

class MySettings (s : Settings) {


    // here we define all our local settings properties,
    // by using the MultiplatformSettings library delegated properties

    var listCacheTimestamp by s.long(defaultValue = 0)
    var savedLevel1URI by s.string(defaultValue = Level1Navigation.AllCountries.screenIdentifier.URI)


}