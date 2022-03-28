package com.example.gk.Module

import android.app.Application
import androidx.lifecycle.LiveData


class UserRepository(app: Application) {
    private val userDao: UserDao

    init {
        val userDatabase: UserDatabase = UserDatabase.getInstance(app)
        userDao = userDatabase.getUserDao()
    }

    suspend fun insertUser(user: User) = userDao.insertUser(user)
    suspend fun updateUser(user: User) = userDao.updateUser(user)
    suspend fun deleteUser(user: User) = userDao.deleteUser(user)

    fun getAlUser(): LiveData<List<User>> = userDao.getAllNote()


}