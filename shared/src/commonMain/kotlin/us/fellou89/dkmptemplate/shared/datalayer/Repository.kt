package us.fellou89.dkmptemplate.shared.datalayer

import app.cash.sqldelight.adapter.primitive.IntColumnAdapter
import com.russhwolf.settings.Settings
import app.cash.sqldelight.db.SqlDriver
import us.fellou89.dkmptemplate.shared.datalayer.sources.localdb.countries.Countries
import us.fellou89.dkmptemplate.shared.datalayer.sources.localsettings.MySettings
import us.fellou89.dkmptemplate.shared.datalayer.sources.runtimecache.CacheObjects
import us.fellou89.dkmptemplate.shared.datalayer.sources.webservices.ApiClient
import kotlinx.coroutines.*
import mylocal.db.LocalDb

class Repository(val sqlDriver: SqlDriver, val settings: Settings = Settings(), val runSynchronously: Boolean = false) {

    internal val webservices by lazy { ApiClient() }
    internal val localDb by lazy { LocalDb(sqlDriver, Countries.Adapter(IntColumnAdapter,IntColumnAdapter,IntColumnAdapter)) }
    internal val localSettings by lazy { MySettings(settings) }
    internal val runtimeCache get() = CacheObjects

    // we run each repository function on a Dispatchers.Default coroutine
    // we pass runSynchronously=true just for the TestRepository instance
    suspend fun <T> withRepoContext (block: suspend () -> T) : T {
        return if (runSynchronously) { // for testing
            block()
        } else { // for production
            withContext(Dispatchers.Default) {
                block()
            }
        }
    }

}