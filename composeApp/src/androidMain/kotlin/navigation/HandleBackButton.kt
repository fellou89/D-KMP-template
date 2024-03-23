package us.fellou89.dkmptemplate.navigation

import androidx.compose.runtime.Composable
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.saveable.SaveableStateHolder
import us.fellou89.dkmptemplate.shared.viewmodel.Navigation
import us.fellou89.dkmptemplate.shared.viewmodel.NavigationState

@Composable
actual fun Navigation.HandleBackButton(
    saveableStateHolder: SaveableStateHolder,
    localNavigationState: MutableState<NavigationState>
) {
    BackHandler(!localNavigationState.value.nextBackQuitsApp) { // catching the back button
        val navState = localNavigationState.value
        val originScreenIdentifier = navState.topScreenIdentifier
        exitScreen(originScreenIdentifier) // shared navigationState is updated
        localNavigationState.value = navigationState // update localNavigationState
        saveableStateHolder.removeState(originScreenIdentifier)
    }
}