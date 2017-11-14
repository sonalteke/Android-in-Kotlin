package com.codekul.filestorage

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.verticalLayout
import java.io.File
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verticalLayout{
            button("Read"){
                onClick {
                    //readInternal()
                    //readExternal()
                    readPublicExternal()
                }
            }
            button("Write"){
                onClick {
                    //writeInternal()
                     //writeExternal()
                    writePublicExternal()
                }
            }
            button("More"){
                onClick {
                    val pathInt = File(filesDir,"my.txt")
                    Log.i("@codekul","""Internal storage path : ${pathInt.absoluteFile}""")

                    val pathExtPv = File(getExternalFilesDir("Downloads"),"my.txt")
                    Log.i("@codekul","""External storage path : ${pathExtPv.absolutePath}""")
                }
            }
        }
    }

    private fun readInternal(){
        val flDt = openFileInput("my.txt")
                .bufferedReader()
                .use {
                    it.readText()
                }
            Log.i("@codekul","File data is: "+flDt)
    }

    private fun writeInternal(){
        val flDt = "This is kotlin file writer"

        openFileOutput(
                "my.txt",
                Context.MODE_PRIVATE
        ).write(flDt.toByteArray())
    }

    private fun readExternal(){
        val flDt = File(getExternalFilesDir("Downloads"),"my.txt")
                .readText(Charset.defaultCharset())

        Log.i("@codekul","""File data is $flDt""")
    }

    private fun writeExternal(){
        val flDt = File(getExternalFilesDir("Downloads"),"my.txt")
                .writeText("This is stored on external storage",
                        Charset.defaultCharset())
    }

    private fun readPublicExternal(){
        val flDt =File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
                ,"my.txt")
                .readText(Charset.defaultCharset())

        Log.i("@codeklu","""File data is $flDt""")
    }

    private fun writePublicExternal(){
        File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
                ,"my.txt")
                .writeText("This is stored on external storage"
                        , Charset.defaultCharset())
    }
}
