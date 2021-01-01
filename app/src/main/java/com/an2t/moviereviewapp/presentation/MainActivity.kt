package com.an2t.moviereviewapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.an2t.moviereviewapp.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

  @Inject
  lateinit var app: BaseApplication

  @Inject
  lateinit var randomString: String

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }


}
