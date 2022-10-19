package com.example.Group7_MAPD711_001_ASSIGNMET2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class storageColor : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var selectedItem: String
    private lateinit var text: String
    private lateinit var colors: Array<String>

    private var buttonName =""
    private var phoneModel =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage_color)
        val bundle = intent.extras
        if (bundle != null){
            // displays data from edit text
            buttonName = " ${bundle.getString("PhoneName")}"
            phoneModel = " ${bundle.getString("Phone_Model")}"

        }
        val radioGroup=findViewById<RadioGroup>(R.id.radioGroup)
        val radio1=findViewById<RadioButton>(R.id.radioGroup1)
        val radio2=findViewById<RadioButton>(R.id.radioGroup2)
        val radio3=findViewById<RadioButton>(R.id.radioGroup3)
        val button=findViewById<Button>(R.id.button)
       colors = resources.getStringArray(R.array.colors)
        radioGroup.setOnCheckedChangeListener { group, checkedId -> // checkedId is the RadioButton selected
         var  rb = findViewById<View>(checkedId) as RadioButton

            val bundle = Bundle()
             text = rb.text.toString()
            bundle.putString("Storage", text)
            Toast.makeText(applicationContext, rb.text, Toast.LENGTH_SHORT).show()
        }

        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.colors,
            android.R.layout.simple_spinner_item
        )
        spinner.onItemSelectedListener = this
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        val initialSelectedPosition: Int = spinner.selectedItemPosition
        spinner.setSelection(initialSelectedPosition, false);
        val selection = ""

        // on below line we are getting the position of the item by the item name in our adapter.
        val spinnerPosition: Int = adapter.getPosition(selection)
        button.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("Storage", text)
            bundle.putString("Color", selectedItem)
            bundle.putString("PhoneName", buttonName)
            bundle.putString("Phone_Model",phoneModel)
            val intent = Intent(this, CustomerInfo::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        // on below line we are setting selection for our spinner to spinner position.
        spinner.setSelection(spinnerPosition)

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // on below line we are displaying toast message for selected item.
        selectedItem = parent?.getItemAtPosition(position).toString()

        Toast.makeText(this, "$selectedItem Selected..", Toast.LENGTH_SHORT)
            .show()

    }
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

}