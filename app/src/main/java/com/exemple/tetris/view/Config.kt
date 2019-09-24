package com.exemple.tetris.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tetris.R
import kotlinx.android.synthetic.main.activity_config.*

class Config : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        var b = Bundle()

        when(R.id.radioGroup){

            R.id.easy->{
                b.putInt("DIFICULT",0)
            }
            R.id.medium->{
                b.putInt("DIFICULT",1)
            }
            R.id.hard->{
                b.putInt("DIFICULT",2)
            }

        }
        backConfig.setOnClickListener {

            var i = Intent(this,MenuActivity::class.java)
            i.putExtras(b)
            setResult(Activity.RESULT_OK,i)
            finish()
        }
    }
}
