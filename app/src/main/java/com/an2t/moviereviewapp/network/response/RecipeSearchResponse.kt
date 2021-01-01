package com.an2t.moviereviewapp.network.response

import com.an2t.moviereviewapp.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse (

  @SerializedName("count")
  var count : Int,

  @SerializedName("results")
  var recipies : List<RecipeDto>

)