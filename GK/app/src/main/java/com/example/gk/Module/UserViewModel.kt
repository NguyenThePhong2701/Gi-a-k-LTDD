package com.example.gk.Module

import android.app.Application
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class UserViewModel(application: Application) : ViewModel() {
    private val userRepository:UserRepository = UserRepository(application)

    fun updateUser(user: User) = viewModelScope.launch {
        userRepository.updateUser(user)
    }

    fun deleteUser(user: User) = viewModelScope.launch {
        userRepository.deleteUser(user)
    }

    fun insertUser(user: User) = viewModelScope.launch {
        userRepository.insertUser(user)
    }

    fun getAllUser() : LiveData<List<User>> = userRepository.getAlUser()

    class UserViewModelFactory (private val application : Application) : ViewModelProvider.Factory{
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(NoteViewModel::class.java)){
                return NoteViewModel(application) as T
            }

            throw IllegalArgumentException("Unable construct viewModel")
        }

    }

}