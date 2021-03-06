package com.example.devayf.fottballclubinformation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private val clubItems: MutableList<ClubItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeData()

        club_information.layoutManager = LinearLayoutManager(this)
        club_information.adapter = ClubAdapter(this, clubItems){
            toast("${it.name}")
            startActivity(intentFor<DetailActivity>("clubName" to it.name))
        }

    }
    private fun initializeData(){
        val clubName = resources.getStringArray(R.array.club_name)
        val clubLogo = resources.obtainTypedArray(R.array.club_logo)
        clubItems.clear()

        for(index in clubName.indices){
            clubItems.add(ClubItem(clubName[index], clubLogo.getResourceId(index, 0)))
        }
        clubLogo.recycle()
    }
}
