package com.afeef.servicetester.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current_state")
data class CurrentState(
    @PrimaryKey val currency: String,
    val rate: Double
)