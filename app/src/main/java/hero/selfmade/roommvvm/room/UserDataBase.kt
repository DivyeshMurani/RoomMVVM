package hero.selfmade.roommvvm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hero.selfmade.roommvvm.model.UserData

@Database(entities = [UserData::class],version = 1,exportSchema = false)
abstract class UserDataBase : RoomDatabase() {

    abstract fun userDataDAO(): DAOAccess

    companion object {
        private var INSTANCE: UserDataBase? = null

        public fun getUserDataBase(context: Context): UserDataBase {

            if (INSTANCE != null) return INSTANCE!!


            synchronized(context) {
                INSTANCE =
                    Room.databaseBuilder(context, UserDataBase::class.java, "USER_DATA")
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return INSTANCE!!
        }
    }

}