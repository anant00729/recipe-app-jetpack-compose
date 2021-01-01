package com.an2t.moviereviewapp.repository

import com.an2t.moviereviewapp.domain.models.Recipe
import com.an2t.moviereviewapp.network.model.RecipeDtoMapper
import com.an2t.moviereviewapp.network.response.RecipeService
import javax.inject.Inject

class RecipeRepository_Impl
@Inject constructor(
  private val recipeService: RecipeService,
  private val mapper: RecipeDtoMapper
) : RecipeRepository {

  override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
    return mapper.toDomainList(
      recipeService.search(
        token = token,
        page = page,
        query = query
      ).recipies
    )
  }

  override suspend fun get(token: String, id: Int): Recipe {
    return mapper.mapToDomainModel(recipeService.get(token = token, id))
  }

}