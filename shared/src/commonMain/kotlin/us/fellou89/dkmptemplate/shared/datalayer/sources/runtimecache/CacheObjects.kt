package us.fellou89.dkmptemplate.shared.datalayer.sources.runtimecache

import us.fellou89.dkmptemplate.shared.datalayer.objects.CountryExtraData

object CacheObjects {
    // here is the repository data we decide to just cache temporarily (for the runtime session),
    // rather than caching it permanently in the local db or local settings

    internal val countryExtraData: MutableMap<String, CountryExtraData> by lazy { mutableMapOf() }

}