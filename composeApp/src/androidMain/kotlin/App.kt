package us.fellou89.dkmptemplate

import android.app.Application
import androidx.lifecycle.*
import us.fellou89.dkmptemplate.shared.viewmodel.DKMPViewModel
import us.fellou89.dkmptemplate.shared.viewmodel.getAndroidInstance

class DKMPApp : Application() {

    lateinit var model: DKMPViewModel

    override fun onCreate() {
        super.onCreate()
        model = DKMPViewModel.Factory.getAndroidInstance(this)
        
        val appLifecycleObserver = AppLifecycleObserver(model)
        ProcessLifecycleOwner.get().lifecycle.addObserver(appLifecycleObserver)
    }

}

class AppLifecycleObserver (private val model: DKMPViewModel) : LifecycleEventObserver {

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START ->
                model.navigation.onEnterForeground()
            Lifecycle.Event.ON_STOP ->
                model.navigation.onEnterBackground()
            else ->
                return
        }
    }

}