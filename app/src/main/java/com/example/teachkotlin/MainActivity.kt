package com.example.teachkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teachkotlin.Unit
import com.example.teachkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = UnitAdapter()
    val listOfUnits = listOf(
        "1 unit",
        "2 unit",
    )
    private val listOfUnitImages = listOf(
        R.drawable.unit1,
        R.drawable.unit2,
    )
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    private fun init() = with(binding) {
        mainRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
        mainRecycler.adapter = adapter
        buttonAdd.setOnClickListener {
            if (counter > 1) {
                counter = 0
            }
            val unit = Unit(listOfUnits[counter], listOfUnitImages[counter])
            adapter.addUnit(unit)
            counter++
        }
    }
}