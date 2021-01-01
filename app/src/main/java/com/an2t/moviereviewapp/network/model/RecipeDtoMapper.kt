package com.an2t.moviereviewapp.network.model

import com.an2t.moviereviewapp.domain.models.Recipe
import com.an2t.moviereviewapp.util.DomainMapper

class RecipeDtoMapper : DomainMapper<RecipeDto, Recipe> {

  override fun mapToDomainModel(model: RecipeDto): Recipe {
    return Recipe(
      id = model.pk,
      title = model.title,
      featuredImage = model.featuredImage,
      rating = model.rating,
      publisher = model.publisher,
      sourceUrl = model.source_url,
      description = model.description,
      cookingInstructions = model.cookingInstructions,
      ingredients = model.ingreients.orEmpty(),
      dateAdded = model.dateAddded,
      dateUpdated = model.dateUpdated,
    )
  }

  override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
    return RecipeDto(
      pk = domainModel.id,
      title = domainModel.title,
      featuredImage = domainModel.featuredImage,
      rating = domainModel.rating,
      publisher = domainModel.publisher,
      source_url = domainModel.sourceUrl,
      description = domainModel.description,
      cookingInstructions = domainModel.cookingInstructions,
      ingreients = domainModel.ingredients,
      dateAddded = domainModel.dateAdded,
      dateUpdated = domainModel.dateUpdated,
    )
  }

  fun toDomainList(initial: List<RecipeDto>): List<Recipe>{
    return initial.map { mapToDomainModel(it) }
  }

  fun fromDomainList(initial: List<Recipe>): List<RecipeDto>{
    return initial.map { mapFromDomainModel(it) }
  }

}