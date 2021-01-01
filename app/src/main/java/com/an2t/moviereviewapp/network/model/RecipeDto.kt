package com.an2t.moviereviewapp.network.model

import com.google.gson.annotations.SerializedName

data class RecipeDto (

  @SerializedName("pk")
  val pk : Int? = null,

  @SerializedName("title")
  val title : String? = null,

  @SerializedName("publisher")
  val publisher : String? = null,

  @SerializedName("rating")
  val rating : Int? = null,

  @SerializedName("source_url")
  val source_url : String? = null,

  @SerializedName("description")
  val description : String? = null,

  @SerializedName("cooking_instructions")
  val cookingInstructions : String? = null,

  @SerializedName("date_added")
  val dateAddded : String? = null,

  @SerializedName("date_updated")
  val dateUpdated : String? = null,

  @SerializedName("ingreients")
  val ingreients : List<String>? = null,

  @SerializedName("featured_image")
  val featuredImage : String? = null,

)