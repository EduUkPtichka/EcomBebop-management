package com.determent.ecombebop_management.shared.a_root.root_decompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Counter(

) {


    var a by remember {
        mutableIntStateOf(1)
    }

    Column(
        modifier = Modifier
            .size(100.dp)
    ) {

        Text(
            text = a.toString(),
            modifier = Modifier
                .clickable {
                    a++
                },
            fontSize = 40.sp
        )
    }

}

//class Memory(
//    val publicff: HashMap<Int, String>?
//){
//
//    var hasmap = HashMap<Int, String>(publicff)
//
//    /*
//    Тут много кода
//     */
//
//    fun nullableExpect(){
//        hasmap = null
//    }
//}