package hero.selfmade.roommvvm.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import hero.selfmade.roommvvm.model.UserData
import hero.selfmade.roommvvm.repository.UserDataRepository

class DataViewModel : ViewModel() {

    fun insertUserData(context: Context, userName: String, surName: String) {
        UserDataRepository.insertUserData(context, userName, surName)
    }

    fun getUserData(context: Context, userId: String): LiveData<UserData> {
        return UserDataRepository.getUserData(context, userId = userId)
    }

    fun getAllUserData(context: Context): LiveData<List<UserData>> {
        return UserDataRepository.getAllData(context)
    }
}