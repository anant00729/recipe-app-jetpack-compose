package com.an2t.moviereviewapp.repository

import com.an2t.moviereviewapp.domain.models.Recipe

interface RecipeRepository {
  suspend fun search(token : String, page : Int, query : String) : List<Recipe>
  suspend fun get(token : String, id : Int) : Recipe
}