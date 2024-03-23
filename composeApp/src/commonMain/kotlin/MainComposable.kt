package us.fellou89.dkmptemplate

import androidx.compose.runtime.Composable
import us.fellou89.dkmptemplate.navigation.Router
import us.fellou89.dkmptemplate.shared.viewmodel.DKMPViewModel

@Composable
fun MainComposable(model: DKMPViewModel) {
    val dkmpNav = model.navigation
    dkmpNav.Router()
}

