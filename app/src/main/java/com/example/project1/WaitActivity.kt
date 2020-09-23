package com.example.project1

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_wait.*

class WaitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wait)
        //Claims list
        val arrayAdapter1: ArrayAdapter<*>
        val claim = arrayOf("Statement1", "Statement2", "Statement3")

        // access the listView from xml file
        var cListView = findViewById<ListView>(R.id.listClaim)
        arrayAdapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, claim)
        cListView.adapter = arrayAdapter1

        listClaim.setOnItemClickListener { parent, view, position, id ->
            val element = parent.getItemAtPosition(position) // The item that was clicked
            val intent = Intent(this, ClaimActivity::class.java)
            startActivity(intent)
        }

        //Start Game
        stGame.setOnClickListener{
            startActivity(Intent(this, ClaimActivity::class.java))
        }

        //End Game
        endGame.setOnClickListener{
            AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id -> super@WaitActivity.onBackPressed() })
                .setNegativeButton("No", null)
                .show()
        }

    }
}