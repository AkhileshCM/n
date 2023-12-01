package com.example.bottomnavbar

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavbar.retrostuffs.Retromethods
import com.example.bottomnavbar.retrostuffs.retroobj
import com.example.bottomnavbar.roomdb.RoomDataBase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val genreList= listOf<String>("Comedy",

            "Crime",
            "Drama",

            "Adventure",

            "Animation",

            "Mystery",
            "Biography",
            "Action",
            "Film-Noir",
            "Horror"
            )
        setContentView(R.layout.activity_main)
        val retroinitilization=retroobj.getinstance().create(Retromethods::class.java)
        lifecycleScope.launch {
                val response=retroinitilization.getMovies()
            if(response.body()!=null){
                val moviedata=response.body()?.movies
                Log.d("nm","${response.body()?.movies}")
                val db=RoomDataBase(applicationContext,null)

                for (i in moviedata!!){

                    if(db.checkmovieexist(i.title)){
                        continue
                    }
                    else{
                        db.addmoviedetails(i.actors,i.director,i.plot,i.posterUrl,i.runtime,i.title,i.genres[0])
                    }
                }

               // Log.d("gh","${cursor.getString(cursor.getColumnIndex(RoomDataBase.genrecolomn))}")



            }

        }

        val recyclerview=findViewById<RecyclerView>(R.id.RecyclerviewMain)
        recyclerview.layoutManager=LinearLayoutManager(applicationContext,RecyclerView.VERTICAL,false)
        recyclerview.adapter=AdapterMain(applicationContext,genreList)




    }
}