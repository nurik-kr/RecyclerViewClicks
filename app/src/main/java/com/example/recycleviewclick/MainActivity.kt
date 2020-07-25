package com.example.recycleviewclick

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewclick.R.menu.menu
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var btnDelete: Button? = null
    val adapter = itemsAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupRecyclerView()
        setupListeners()
    }

    private fun setupView() {
        recyclerView = findViewById(R.id.recycler)
        btnDelete = findViewById(R.id.delete)
    }

    private fun setupRecyclerView() {
        recyclerView?.adapter = adapter
        adapter.update(getData())
    }

    private fun setupListeners() {
        btnDelete?.setOnClickListener {
            adapter.run { delete(1) }
        }
    }

    private fun getData(): ArrayList<ItemsData> {
        val list = arrayListOf<ItemsData>()

        for (i in 1..50) {
            list.add(ItemsData("title $i", "decs $i"))
        }

        return list
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate((R.menu.menu), menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add -> adapter.add(ItemsData("new", "add"))
        }
        return super.onOptionsItemSelected(item)
    }
}
