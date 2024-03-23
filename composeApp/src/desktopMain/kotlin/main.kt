import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import us.fellou89.dkmptemplate.MainComposable
import us.fellou89.dkmptemplate.styling.MyMaterialTheme
import us.fellou89.dkmptemplate.shared.viewmodel.DKMPViewModel
import us.fellou89.dkmptemplate.shared.viewmodel.getDesktopInstance


fun main() = application {
    val model = DKMPViewModel.Factory.getDesktopInstance()
    Window(
        onCloseRequest = ::exitApplication,
        title = "D-KMP sample for Compose Desktop",
        state = rememberWindowState(width = 1050.dp, height = 700.dp),
    ) {
        MyMaterialTheme {
            MainComposable(model)
        }
    }
}
