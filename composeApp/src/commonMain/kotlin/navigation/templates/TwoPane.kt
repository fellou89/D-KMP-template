package us.fellou89.dkmptemplate.navigation.templates

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.saveable.SaveableStateHolder
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import us.fellou89.dkmptemplate.navigation.*
import us.fellou89.dkmptemplate.navigation.bars.Level1NavigationRail
import us.fellou89.dkmptemplate.navigation.bars.TopBar
import us.fellou89.dkmptemplate.shared.viewmodel.Navigation
import us.fellou89.dkmptemplate.shared.viewmodel.NavigationState
import us.fellou89.dkmptemplate.shared.viewmodel.ScreenIdentifier

@Composable
fun Navigation.TwoPane(
    saveableStateHolder: SaveableStateHolder,
    localNavigationState: MutableState<NavigationState>
) {
    val title = getTitle(localNavigationState.value.topScreenIdentifier)
    val masterScreenIdentifier = twoPaneMasterScreen(localNavigationState)
    val detailScreenIdentifier = twoPaneDetailScreen(localNavigationState)
    Scaffold(
        topBar = { TopBar(title) },
        content = { contentPadding ->
            Row(Modifier.padding(contentPadding)) {
                Column(Modifier
                    .fillMaxHeight()
                    .width(100.dp)) {
                        Level1NavigationRail(masterScreenIdentifier, level1NavigationProcessor(localNavigationState))
                }
                Column(Modifier
                    .weight(0.4f)) {
                        saveableStateHolder.SaveableStateProvider(masterScreenIdentifier.URI) {
                            ScreenPicker(masterScreenIdentifier, navigationProcessor(localNavigationState))
                        }
                }
                Column(Modifier
                    .weight(0.6f)
                    .padding(20.dp)) {
                        if (detailScreenIdentifier == null) {
                            TwoPaneDefaultDetail(masterScreenIdentifier)
                        } else {
                            saveableStateHolder.SaveableStateProvider(detailScreenIdentifier.URI) {
                                ScreenPicker(detailScreenIdentifier, navigationProcessor(localNavigationState))
                            }
                        }
                }
            }
        }
    )
}



fun Navigation.twoPaneMasterScreen(navState: MutableState<NavigationState>) : ScreenIdentifier {
    return navState.value.currentLevel1ScreenIdentifier
}

fun Navigation.twoPaneDetailScreen(navState: MutableState<NavigationState>) : ScreenIdentifier? {
    if (navState.value.topScreenIdentifier.screen.navigationLevel > 1) {
        return navState.value.topScreenIdentifier
    } else {
        return null
    }
}