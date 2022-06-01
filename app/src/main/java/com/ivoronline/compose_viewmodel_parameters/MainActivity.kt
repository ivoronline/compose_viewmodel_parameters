package com.ivoronline.compose_viewmodel_parameters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*

//==========================================================
// MAIN ACTIVITY
//==========================================================
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val myViewModel = MyViewModel()                                        //Create Model Instance

    setContent {
      Column {
        MyCounter(myViewModel.count, myViewModel.name) { amount, suffix -> //Last Parameter is Lambda
          myViewModel.increase(amount)                    //Call Function that updates State Variable count
          myViewModel.concat  (suffix)                    //Call Function that updates State Variable name
        }
      }
    }
  }
}

//==========================================================
// COUNTER (Destination Composable)
//==========================================================
@Composable
fun MyCounter(
  counter        : Int,                         //First  State Variable to read
  name           : String,                      //Second State Variable to read
  increaseCounter: (Int, String) -> Unit        //Call Functions that update State Variables
) {
  Button({
    increaseCounter(10, " hi")                  //Call Functions that update State Variables
  }) {
    Text("(Count, Name) = ($counter, $name)")   //Display State Variables
  }
}
