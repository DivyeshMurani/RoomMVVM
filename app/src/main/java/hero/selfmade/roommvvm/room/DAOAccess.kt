package hero.selfmade.roommvvm.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hero.selfmade.roommvvm.model.UserData

@Dao
interface DAOAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserData(userData: UserData)

    @Query("SELECT * FROM UserData WHERE userName=:userId")
    fun getUserData(userId: String): LiveData<UserData>

    @Query("SELECT * FROM UserData")
    fun getAllData(): LiveData<List<UserData>>

}