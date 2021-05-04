package com.example.spinnerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.spinnerexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val balls = listOf("Basketball", "Football", "Baseball")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // data source comes from an array
        //val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, balls)
        //data source comes from a resource file
        val adapter = ArrayAdapter.createFromResource(this, R.array.balls, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //default selection is the first item
                val selected = parent?.getItemAtPosition(position).toString()
                binding.textView.text = getString(R.string.favorite, selected)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}