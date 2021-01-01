package com.an2t.moviereviewapp.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.an2t.moviereviewapp.network.model.RecipeDtoMapper
import com.an2t.moviereviewapp.presentation.components.HomeAppBar
import com.an2t.moviereviewapp.presentation.components.Loader
import com.an2t.moviereviewapp.presentation.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.an2t.moviereviewapp.R

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

  val viewModel: RecipeListViewModel by viewModels()

  @Inject
  lateinit var mapper: RecipeDtoMapper

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    print("on Create Recipe List Fragment >> ${viewModel}")
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    val view = ComposeView(requireContext())
    view.apply {
      setContent {
        val recipes = viewModel.recipes.value
        val query = viewModel.query.value
        val selectedCategory = viewModel.selectedCategory.value
        val isLoading = viewModel.isLoading.value

        Column {
          HomeAppBar(
            query = query,
            onQueryChanged = viewModel::onQueryChanged,
            newSearch = viewModel::newSearch,
            categoryScrollPosition = viewModel.categoryScrollPosition,
            selectedCategory = selectedCategory,
            onSelectedCategory = viewModel::onSelectedCategory,
            onChangeCategoryPosition = viewModel::onChangeCategoryPosition,
          )
          Spacer(modifier = Modifier.padding(4.dp))
          Box(
            modifier = Modifier.fillMaxSize()
          ) {
            LazyColumn {
              itemsIndexed(items = recipes) { index, item ->
                RecipeCard(recipe = item, onClick = {
                  findNavController().navigate(R.id.viewRecipe)
                })
              }
            }
            Loader(
              isDisplayed = isLoading
            )
          }
          Spacer(modifier = Modifier.padding(4.dp))
        }
      }
    }
    return view
  }


}