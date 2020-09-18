package com.example.retrofitexample.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TerrainDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTerrain(mTerrainList: List<Terrain>)

    @Query("SELECT * FROM terrain_table")
    fun getAllTerrainsFromDB(): LiveData<List<Terrain>>
}