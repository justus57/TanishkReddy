package com.example.Group7_MAPD711_001_ASSIGNMET2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class Reciept : AppCompatActivity() {
    lateinit var name: TextView
    lateinit var address: TextView
    lateinit var CvvID: TextView
    lateinit var city: TextView
    lateinit var postalCodeid: TextView
    lateinit var credit_card_numberED: TextView
    lateinit var PhoneNameID: TextView
    lateinit var PhoneModelID: TextView
    lateinit var Phone_ColorID: TextView
    lateinit var Phone_StorageID: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reciept)

        name =  findViewById(R.id.name)
        address =findViewById(R.id.address)
        CvvID = findViewById(R.id.CvvID)
        city = findViewById(R.id.city)
        postalCodeid = findViewById(R.id.postalCodeid)
        credit_card_numberED =findViewById(R.id.creditCardNumberID)
        PhoneNameID = findViewById(R.id.PhoneNameID)
        PhoneModelID = findViewById(R.id.PhoneModelID)
        Phone_ColorID =findViewById(R.id.Phone_ColorID)
        Phone_StorageID = findViewById(R.id.Phone_StorageID)

        val bundle = intent.extras
        if (bundle != null){

            // displays data from edit text
            name.text = " ${bundle.getString("name")}"
            address.text = "${bundle.getString("address")}"
            city.text = "${bundle.getString("city")}"
            CvvID.text = "${bundle.getString("CVV")}"
            postalCodeid.text = "${bundle.getString("postalCode")}"
            PhoneNameID.text = "${bundle.getString("PhoneName")}"
            PhoneModelID.text = "${bundle.getString("Phone_Model")}"
            Phone_ColorID.text = "${bundle.getString("Phone_Color")}"
            Phone_StorageID.text = "${bundle.getString("Storage")}"
            credit_card_numberED.text = "${bundle.getString("credit_card_numberED")}"
        }
    }
}