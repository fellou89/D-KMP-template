package us.fellou89.dkmptemplate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.saveable.SaveableStateHolder
import us.fellou89.dkmptemplate.shared.viewmodel.Navigation
import us.fellou89.dkmptemplate.shared.viewmodel.NavigationState

@Composable
expect fun Navigation.HandleBackButton(
    saveableStateHolder: SaveableStateHolder,
    localNavigationState: MutableState<NavigationState>,
)