package preview.a_camera

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.determent.ecombebop_management.shared.camera.camera_take_picture.presenter.CameraBottomBar

@Preview
@Composable
private fun PreviewCameraBottomBar() {
    CameraBottomBar(
        onTakePicture = {},
        onClickBackNav = {},
    )
}