package com.exemple.tetris.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tetris.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    val COD = 0
    val PREFS = "prefs_file"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var settings = getSharedPreferences(PREFS,Context.MODE_PRIVATE)


        newGame.setOnClickListener {
            var i = Intent(this,BoardActivity::class.java)
            var b = Bundle()
            b.putInt("DIFICULT",settings.getInt("DIFICULT",1))
            i.putExtras(b)
            startActivity(i)
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
