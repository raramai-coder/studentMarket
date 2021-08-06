package com.example.studentmarket.ui

import androidx.lifecycle.ViewModel

class FragmentHomesViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val users: MutableLiveData<List<User>> by lazy{
        MutableLiveData<List<User>>().also {
            loadUsers()

        }
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    private fun loadUsers() {
        //Do an asynchronous operation to fetch users.
    }
}