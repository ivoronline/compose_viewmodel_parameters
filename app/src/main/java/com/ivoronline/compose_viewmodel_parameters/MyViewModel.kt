package com.ivoronline.compose_viewmodel_parameters

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MyViewModel {

  //STATE VARIABLES (Business Data)
  var count by mutableStateOf(0)
  var name  by mutableStateOf("Hello")

  //FUNCTIONS       (Business Logic)
  fun increase(amount: Int   ) { count += amount; }
  fun concat  (suffix: String) { name  += suffix; }

}
