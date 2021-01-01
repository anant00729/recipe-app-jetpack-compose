package com.an2t.moviereviewapp.di

import com.an2t.moviereviewapp.network.model.RecipeDtoMapper
import com.an2t.moviereviewapp.network.response.RecipeService
import com.an2t.moviereviewapp.repository.RecipeRepository
import com.an2t.moviereviewapp.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RespositoryModule  {

  @Singleton
  @Provides
  fun provideRecipeRepository(
    recipeService: RecipeService,
    recipeMapper: RecipeDtoMapper,
  ): RecipeRepository{
    return RecipeRepository_Impl(
      recipeService = recipeService,
      mapper = recipeMapper
    )
  }
}