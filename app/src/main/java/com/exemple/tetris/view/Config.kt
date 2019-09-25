package com.exemple.tetris.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tetris.R
import kotlinx.android.synthetic.main.activity_config.*

class Config : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        var b = Bundle()



        backConfig.setOnClickListener {

            if(easy.isChecked){
                b.putInt("DIFICULT",0)
            }
            if(medium.isChecked){
                b.putInt("DIFICULT",1)
            }
            if(hard.isChecked){
                b.putInt("DIFICULT",2)
            }

            Toast.makeText(this,"${b.getInt("DIFICULT")}",Toast.LENGTH_SHORT).show()

            var i = Intent(this,MenuActivity::class.java)
            i.putExtras(b)
            setResult(Activity.RESULT_OK,i)
            finish()
        }
    }
}
