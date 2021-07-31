package hero.selfmade.roommvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import hero.selfmade.roommvvm.model.UserData
import hero.selfmade.roommvvm.room.UserDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDataRepository {


    companion object {

        private fun initDatabase(context: Context): UserDataBase {
            return UserDataBase.getUserDataBase(context)
        }

        fun insertUserData(context: Context, userName: String, surName: String) {
            CoroutineScope(Dispatchers.IO).launch {
                val userData = UserData(userName, surName)
                initDatabase(context).userDataDAO().insertUserData(userData)
            }
        }

        fun getUserData(context: Context, userId: String): LiveData<UserData> {
            return initDatabase(context).userDataDAO().getUserData(userId)

        }

        fun getAllData(context: Context):LiveData<List<UserData>>{
            return initDatabase(context).userDataDAO().getAllData()
        }
    }
}