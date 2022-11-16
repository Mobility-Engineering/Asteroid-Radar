package com.udacity.asteroidradar.main

import android.app.Application
import android.view.View
import androidx.lifecycle.*
import com.udacity.asteroidradar.bindTextViewToDisplayVelocity
import com.udacity.asteroidradar.database.AsteroidDao
import com.udacity.asteroidradar.database.AsteroidEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    val database: AsteroidDao,
    application: Application
) : AndroidViewModel(application) {

     val today: String = "YYYY-MM-DD"
     var onProgress = false
    private val asteroids = database.getAllAsteroids()
    private val todayAsteroids = database.getTodayAsteroids(today)
    //From where can today be obtained in the specified format

     val testText = "test text"
     val progressVisibility = View.GONE




    private fun insert(asteroid: AsteroidEntity){
        viewModelScope.launch{
            insertAsteroid(asteroid)
        }
    }
    suspend fun insertAsteroid(asteroid:AsteroidEntity){
        withContext(Dispatchers.IO){
            database.insert(asteroid)
        }
    }


    fun someWorkToBeDone(){
        viewModelScope.launch {
            suspendFunction()
        }
    }

        suspend fun suspendFunction(){
            withContext(Dispatchers.IO){
                //Do long running work here i.e get all asteroids/insert all asteroids
            }
        }

    }

