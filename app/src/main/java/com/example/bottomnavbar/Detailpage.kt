package com.example.bottomnavbar

import android.os.Bundle
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class Detailpage:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailpage)
        val videoview=findViewById<VideoView>(R.id.vvfortrailer)
        val title=findViewById<TextView>(R.id.tvTitle)
        val year=findViewById<TextView>(R.id.tvyear)

        val agelimittv=findViewById<TextView>(R.id.tvagelimit)
        val plot=findViewById<TextView>(R.id.tvplot)
        val actortv=findViewById<TextView>(R.id.tvstarring)
        val directortv=findViewById<TextView>(R.id.tvdirector)

        val titleset:String?=intent.getStringExtra("moviename")
        val runtime:String?=intent.getStringExtra("time")
        val plotadd:String?=intent.getStringExtra("plot")
        val actors:String?=intent.getStringExtra("actor")
        val directors:String?=intent.getStringExtra("director")


        title.text=titleset
        year.text=runtime
        agelimittv.text="U/A 16+"
        plot.text=plotadd
        actortv.text=actors
        directortv.text=directors





    }
}