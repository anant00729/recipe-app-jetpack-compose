package com.an2t.moviereviewapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FoodCategoryChip(
  index : Int,
  isSelected : Boolean,
  onCategorySelected : (String) -> Unit,
  category : String,
  onExecuteSearch : () -> Unit
){
  var startPadding = 0.dp
  if(index == 0){
    startPadding = 8.dp
  }
  Surface(
    modifier = Modifier.padding(end=8.dp, start = startPadding),
    elevation=8.dp,
    shape = MaterialTheme.shapes.medium,
    color= if(isSelected) Color.LightGray else MaterialTheme.colors.primary
  ) {
    Row(
      modifier = Modifier.toggleable(value = isSelected, onValueChange = {
        onCategorySelected(category)
        onExecuteSearch()
      })
    ){
      Text(
        text = category,
        style = MaterialTheme.typography.body2,
        color = Color.White,
        modifier = Modifier.padding(8.dp)
      )
    }
  }
}