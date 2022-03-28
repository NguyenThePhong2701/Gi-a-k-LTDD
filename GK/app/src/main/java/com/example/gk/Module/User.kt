package com.example.gk.Module

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
class User(
    @ColumnInfo(name = "name")val name : String = "",
    @ColumnInfo(name = "sdt")val sdt : String = "",
    @ColumnInfo(name = "email")val email : String = "",
    @ColumnInfo(name = "password")val password : String = "",
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    var id:Int = 0
}