package us.fellou89.dkmptemplate.shared.viewmodel

import us.fellou89.dkmptemplate.shared.datalayer.Repository
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import mylocal.db.LocalDb


fun DKMPViewModel.Factory.getIosInstance() : DKMPViewModel {
    val sqlDriver = NativeSqliteDriver(LocalDb.Schema, "Local.db")
    val repository = Repository(sqlDriver)
    return DKMPViewModel(repository)
}