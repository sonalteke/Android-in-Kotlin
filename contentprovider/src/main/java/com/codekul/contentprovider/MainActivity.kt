package com.codekul.contentprovider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import org.jetbrains.anko.listView
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readContact()
    }

    private fun readContact(){
        val dtSt = ArrayList<String>()
        val crSr = contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER
                ),
                null,
                null,
                null
        )

        while (crSr.moveToNext()){
            val nm = crSr.getString(
                    crSr.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))

            val num = crSr.getString(
                    crSr.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

            dtSt.add("""$nm \n $num""")
        }

        crSr.close()

        verticalLayout{
            val lst = listView {
                adapter = ArrayAdapter<String>(
                        this@MainActivity,
                        android.R.layout.simple_dropdown_item_1line,
                        dtSt
                )
            }

            }
        }

    }

