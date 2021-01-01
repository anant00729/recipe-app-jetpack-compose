package com.an2t.moviereviewapp.presentation.ui.recipe_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.an2t.moviereviewapp.domain.models.Recipe
import com.an2t.moviereviewapp.network.model.RecipeDtoMapper
import com.an2t.moviereviewapp.repository.RecipeRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Named

class RecipeListViewModel
@ViewModelInject
constructor(
  private val repository: RecipeRepository,
  private @Named("auth_token") val token: String,
) : ViewModel() {

  val recipes: MutableState<List<Recipe>> = mutableStateOf(ArrayList())
  val query = mutableStateOf("")
  val isLoading = mutableStateOf(true)
  val selectedCategory: MutableState<FoodCategory?> = mutableStateOf(null)
  var categoryScrollPosition = 0.0f

  init {
    newSearch()
  }

  fun newSearch() {
    viewModelScope.launch {
      isLoading.value = true
      resetSearchState()
      delay(1500)
      val result = repository.search(
        token = token,
        page = 1,
        query = query.value
      )
      recipes.value = result
      isLoading.value = false
    }
  }

  /**
   * Called when a new search is executed.
   */
  private fun resetSearchState(){
    recipes.value = listOf()
    if(selectedCategory.value?.value != query.value) clearSelectedCategory()
  }

  private fun clearSelectedCategory(){
    selectedCategory.value = null
  }

  fun onQueryChanged(query: String){
    this.query.value = query
  }

  fun onSelectedCategory(category : String) {
    val newCategory = getFoodCategory(category)
    selectedCategory.value = newCategory
    onQueryChanged(category)
  }

  fun onChangeCategoryPosition(position : Float) {
    categoryScrollPosition = position
  }

}