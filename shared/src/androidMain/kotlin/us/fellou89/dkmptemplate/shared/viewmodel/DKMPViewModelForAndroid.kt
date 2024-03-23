package us.fellou89.dkmptemplate.shared.viewmodel

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import us.fellou89.dkmptemplate.shared.datalayer.Repository
import mylocal.db.LocalDb


fun DKMPViewModel.Factory.getAndroidInstance(context : Context) : DKMPViewModel {
    val sqlDriver = AndroidSqliteDriver(LocalDb.Schema, context, "Local.db")
    val repository = Repository(sqlDriver)
    return DKMPViewModel(repository)
}