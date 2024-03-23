package us.fellou89.dkmptemplate.shared

import com.russhwolf.settings.MapSettings
import us.fellou89.dkmptemplate.shared.datalayer.Repository
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import mylocal.db.LocalDb

actual fun getTestRepository() : Repository {
    val sqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    LocalDb.Schema.create(sqlDriver)
    return Repository(sqlDriver, MapSettings(), true)
}