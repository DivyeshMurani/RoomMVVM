package hero.selfmade.roommvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import hero.selfmade.roommvvm.model.UserData
import hero.selfmade.roommvvm.viewmodel.DataViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        dataViewModel.insertUserData(
            applicationContext,
            "Divyesh", "Murani"
        )

        dataViewModel.insertUserData(
            applicationContext,
            "Yagnik", "Murani"
        )

        dataViewModel.getUserData(context = applicationContext, "Divyesh").observe(this, Observer {
            Log.e("developer", "User Name : " + it.userName)
//            Log.e("developer", "Sur Name : " + it.surName)
        })

        dataViewModel.getAllUserData(applicationContext).observe(this, Observer {

            Log.d("developer","Size :: ${it.size}")

            for (value in it) {
                Log.d("developer", "userName :: ${value.userName}")
            }
        })


    }
}