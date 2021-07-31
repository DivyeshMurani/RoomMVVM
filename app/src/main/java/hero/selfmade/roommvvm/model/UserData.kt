package hero.selfmade.roommvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.String

@Entity(tableName = "UserData")
data class UserData(

    @ColumnInfo(name = "userName")
    var userName: String,

    @ColumnInfo(name = "surName")
    var surName: String

) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
        get() = field
        set(value) {
            field = value
        }
}