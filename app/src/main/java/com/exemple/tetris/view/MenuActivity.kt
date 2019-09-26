package com.exemple.tetris.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tetris.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    val COD = 5
    val PREFS = "prefs_file2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        var contin: Boolean
        var settings = getSharedPreferences(PREFS,Context.MODE_PRIVATE)
        contin = intent.extras?.getBoolean("CONTINUE") ?: false
        if(!contin){
            resumeGame.visibility = View.GONE
        }

        resumeGame.setOnClickListener {
            var i = Intent(this,BoardActivity::class.java)
            var b = Bundle()
            b.putInt("DIFICULT",settings.getInt("DIFICULT",1))
            i.putExtras(b)
            startActivity(i)
        }

        newGame.setOnClickListener {
            var i = Intent(this,BoardActivity::class.java)
            var b = Bundle()
            b.putInt("DIFICULT",settings.getInt("DIFICULT",1))
            i.putExtras(b)
            startActivity(i)
            finish()
        }

        configGame.setOnClickListener {
            var i = Intent(this,Config::class.java)
            startActivityForResult(i,COD)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var settings = getSharedPreferences(PREFS,Context.MODE_PRIVATE)
        var editor = settings.edit()
        val params = data?.extras

        when(resultCode){
                Activity.RESULT_OK->{
                    editor.clear()
                    editor.putInt("DIFICULT", params!!.getInt("DIFICULT"))
                    editor.commit()
                }
        }

    }
}
