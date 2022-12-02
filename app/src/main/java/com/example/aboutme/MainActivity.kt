package com.example.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Stefan Antonijevic")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
    }
    private fun addNickname(view: View){
        binding.apply{
            myName?.nickname = nicknameEdit.text.toString()
            binding.nicknameText.text = binding.nicknameEdit.text
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameEdit.visibility = View.VISIBLE
        }


        //Cacher le clavier
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

}