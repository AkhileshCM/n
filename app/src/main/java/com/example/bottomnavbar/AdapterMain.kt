package com.example.bottomnavbar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavbar.roomdb.RoomDataBase
import org.w3c.dom.Text

class AdapterMain(val context: Context,val genres:List<String>):RecyclerView.Adapter<Myviewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val inflater=LayoutInflater.from(parent.context)
        val list=inflater.inflate(R.layout.recycleritem,parent,false)


        return Myviewholder(list)

    }

    override fun getItemCount(): Int {



        return genres.size

    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        holder.item1.text=genres[position]
        holder.item2.layoutManager=LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        holder.item2.adapter=GridAdapter(context,genres[position])

    }

}

class Myviewholder(val view: View):RecyclerView.ViewHolder(view){
    val item1=view.findViewById<TextView>(R.id.tvcategory)
    val item2=view.findViewById<RecyclerView>(R.id.rvmain)
}