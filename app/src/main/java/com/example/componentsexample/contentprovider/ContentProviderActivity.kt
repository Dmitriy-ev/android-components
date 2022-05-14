package com.example.componentsexample.contentprovider

import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.componentsexample.R

class ContentProviderActivity : AppCompatActivity() {

    var contacts = listOf(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID
    ).toTypedArray()

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        listView = findViewById(R.id.contact_list_view)

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                Array(1) { android.Manifest.permission.READ_CONTACTS },
                100
            )
        } else {
            readUserContacts()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            readUserContacts()
        }
    }

    private fun readUserContacts()
    {
        val source = listOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        ).toTypedArray()
        val destination = intArrayOf(android.R.id.text1, android.R.id.text2)
        val resultSet = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            contacts, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
        val adapter = SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, resultSet,
            source, destination, 0);
        listView.adapter = adapter
    }
}