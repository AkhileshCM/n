package com.example.bottomnavbar

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.bottomnavbar.roomdb.RoomDataBase
import com.squareup.picasso.Picasso

class GridAdapter(val context: Context,val type:String):RecyclerView.Adapter<viewholderforlistitem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholderforlistitem {
        val infater=LayoutInflater.from(parent.context)
        val poster=infater.inflate(R.layout.listitem,parent,false)
        return viewholderforlistitem(poster)

    }

    override fun getItemCount(): Int {
        val db=RoomDataBase(context,null)
        val cursor=db.getmoviebasedoncategory(type)
        Log.d("count##","${cursor!!.count}")
        return cursor!!.count



    }

    @SuppressLint("Range")
    override fun onBindViewHolder(holder: viewholderforlistitem, position: Int) {
        Log.d("jhjhj","${10}")
        val db=RoomDataBase(context,null)
        val cursor2=db.getmoviebasedoncategory(type)
        cursor2!!.moveToPosition(position)

        var imglink = cursor2.getString(cursor2.getColumnIndex("PosterUrl"))
        var title = cursor2.getString(cursor2.getColumnIndex("Title"))
        var runtime=cursor2.getString(cursor2.getColumnIndex("Runtime"))
        val plot=cursor2.getString(cursor2.getColumnIndex("Plot"))
        val actors=cursor2.getString(cursor2.getColumnIndex("Actors"))
        val directors=cursor2.getString(cursor2.getColumnIndex("Director"))
        Log.d("fh","${imglink}")
        if(imglink==""){
            holder.image.setImageResource(R.drawable.placeholderimg)
            Log.d("#######","${imglink is String}")
        }
        else{
            Picasso.get().load(imglink).placeholder(R.drawable.placeholderimg).centerCrop().fit()
                .into(holder.image)
        }
        holder.text.text = title
        holder.image.setOnClickListener {
            Log.d("clicked","image clicked")
            val intent= Intent(holder.view.context,Detailpage::class.java)
            intent.putExtra("moviename",title)
            intent.putExtra("time",runtime)
            intent.putExtra("plot",plot)
            intent.putExtra("actor",actors)
            intent.putExtra("director",directors)
            holder.view.context.startActivity(intent)
        }


//        imglink = cursor2.getString(cursor2.getColumnIndex("PosterUrl"))
//        title = cursor2.getString(cursor2.getColumnIndex("Title"))
//            Log.d("image", title)
//            Log.d("image", imglink)
//            Picasso.get().load(imglink).placeholder(R.drawable.placeholderimg).centerCrop().fit()
//                .into(holder.image)
//            holder.text.text = title







    }


}
class viewholderforlistitem(val view:View):ViewHolder(view){
    val image=view.findViewById<ImageView>(R.id.imgaeforposter)
    val text=view.findViewById<TextView>(R.id.tvforpostername)

}