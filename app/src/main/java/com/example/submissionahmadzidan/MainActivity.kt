package com.example.submissionahmadzidan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUniversity: RecyclerView
    private val list = ArrayList<Universitas>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUniversity = findViewById(R.id.rv_university)
        rvUniversity.setHasFixedSize(true)

        list.addAll(getListUniversity())
        showRecylerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, Moveactivity::class.java)
                startActivity(moveIntent)
                //rvUniversity.layoutManager = LinearLayoutManager(this)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListUniversity(): ArrayList<Universitas> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listUniversitas = ArrayList<Universitas>()
        for (i in dataName.indices){
            val universitas = Universitas(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listUniversitas.add(universitas)
        }
        return listUniversitas
    }

    private fun showRecylerList(){
        rvUniversity.layoutManager = LinearLayoutManager(this)
        val listUniversitasAdapter = ListUniversitasAdapter(list)
        rvUniversity.adapter = listUniversitasAdapter

        listUniversitasAdapter.setOnItemClickCallback(object : ListUniversitasAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Universitas) {
                val moveWithDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                moveWithDataIntent.putExtra(DetailActivity.EXTRA_NAME, data.name)
                moveWithDataIntent.putExtra(DetailActivity.EXTRA_DESCRIPTION, data.description)
                moveWithDataIntent.putExtra(DetailActivity.EXTRA_PHOTO, data.photo)
                startActivity(moveWithDataIntent)
            }
        })
    }

    private fun showSelectedUniversitas(universitas: Universitas) {
        Toast.makeText(this, "Kamu Memilih " + universitas.name, Toast.LENGTH_SHORT).show()
    }
}