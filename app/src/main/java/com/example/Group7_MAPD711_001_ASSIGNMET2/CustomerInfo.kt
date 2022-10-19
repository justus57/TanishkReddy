package com.example.Group7_MAPD711_001_ASSIGNMET2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText



class CustomerInfo : AppCompatActivity() {
   lateinit var buttonName: String
   lateinit var phoneModel: String
    lateinit var code: EditText
    lateinit var creditabilitiesED:EditText
    lateinit var name: EditText
    lateinit var address: EditText
    lateinit var city: EditText
    lateinit var postalCode: EditText
    lateinit var submit: Button

    private var phoneColor =""
    private var storage =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_info)
        val bundle = intent.extras
        if (bundle != null){
            // displays data from edit text
             buttonName = " ${bundle.getString("PhoneName")}"
             phoneModel = " ${bundle.getString("Phone_Model")}"
            phoneColor = " ${bundle.getString("Color")}"
             storage = " ${bundle.getString("Storage")}"
        }
        name =  findViewById(R.id.name)
        address =findViewById(R.id.address)
        city = findViewById(R.id.city)
        postalCode = findViewById(R.id.postalCodeId)
        creditabilitiesED = findViewById(R.id.creditcardnumberId)
        code = findViewById(R.id.cvvId)
        submit = findViewById(R.id.button)
        submit.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", name.text.toString())
            bundle.putString("address", address.text.toString())
            bundle.putString("city", city.text.toString())
            bundle.putString("CVV", code.text.toString())
            bundle.putString("postalCode", postalCode.text.toString())
            bundle.putString("credit_card_numberED", creditabilitiesED.text.toString())
            bundle.putString("PhoneName", buttonName)
            bundle.putString("Phone_Model",phoneModel)
            bundle.putString("Phone_Color", phoneColor)
            bundle.putString("Storage",storage )
            val intent = Intent(this, Reciept::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}