package preview.list_product

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.determent.ecombebop_management.shared.a_root.root_decompose.Counter

@Preview
@Composable
private fun Preview(){
    Counter()
}

//var a by remember {
//    mutableIntStateOf(1)
//}
//
//Column(
//modifier = Modifier
//.size(100.dp)
//) {
//    Text(
//        text = a.toString(),
//        modifier = Modifier
//            .clickable {
//                a++
//            },
//        fontSize = 40.sp
//    )
//}
//
//}

