package us.fellou89.dkmptemplate.navigation.templates

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.saveable.SaveableStateHolder
import androidx.compose.ui.Modifier
import us.fellou89.dkmptemplate.navigation.*
import us.fellou89.dkmptemplate.navigation.bars.Level1BottomBar
import us.fellou89.dkmptemplate.navigation.bars.TopBar
import us.fellou89.dkmptemplate.shared.viewmodel.Navigation
import us.fellou89.dkmptemplate.shared.viewmodel.NavigationState

@Composable
fun Navigation.OnePane(
    saveableStateHolder: SaveableStateHolder,
    localNavigationState: MutableState<NavigationState>
) {
    val screenIdentifier = localNavigationState.value.topScreenIdentifier
    val title = getTitle(screenIdentifier)
    Scaffold(
        topBar = { TopBar(title) },
        content = { contentPadding ->
            Row(Modifier.padding(contentPadding)) {
                saveableStateHolder.SaveableStateProvider(screenIdentifier.URI) {
                    ScreenPicker(screenIdentifier, navigationProcessor(localNavigationState))
                }
            }
        },
        bottomBar = { if (screenIdentifier.screen.navigationLevel == 1) Level1BottomBar(screenIdentifier, level1NavigationProcessor(localNavigationState)) }
    )
}