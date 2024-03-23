package us.fellou89.dkmptemplate.shared

import com.russhwolf.settings.MapSettings
import us.fellou89.dkmptemplate.shared.datalayer.Repository
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import mylocal.db.LocalDb


actual fun getTestRepository() : Repository {
    val sqlDriver = NativeSqliteDriver(LocalDb.Schema, "test.db")
    return Repository(sqlDriver, MapSettings(), true)
}