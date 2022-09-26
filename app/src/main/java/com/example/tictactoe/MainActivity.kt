package com.example.tictactoe

import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tictactoe.databinding.ActivityMainBinding
import java.util.logging.Logger.global

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners(){

        val clickableViews = listOf(
            binding.tile11,
            binding.tile21,
            binding.tile31,
            binding.tile12,
            binding.tile22,
            binding.tile32,
            binding.tile13,
            binding.tile23,
            binding.tile33)

        for (item in clickableViews){

            item.setOnClickListener{ makeColored(it) }

        }
    }

    var turn = 0
    private fun makeColored(view: View){

        val tileColor = if (turn % 2 == 0){
            R.color.myRed
        } else {
            R.color.myBlue
        }

        when(view.id){
            R.id.tile_1_1 -> view.setBackgroundResource(tileColor)
            R.id.tile_2_1 -> view.setBackgroundResource(tileColor)
            R.id.tile_3_1 -> view.setBackgroundResource(tileColor)
            R.id.tile_1_2 -> view.setBackgroundResource(tileColor)
            R.id.tile_2_2 -> view.setBackgroundResource(tileColor)
            R.id.tile_3_2 -> view.setBackgroundResource(tileColor)
            R.id.tile_1_3 -> view.setBackgroundResource(tileColor)
            R.id.tile_2_3 -> view.setBackgroundResource(tileColor)
            R.id.tile_3_3 -> view.setBackgroundResource(tileColor)
        }

        turn++
    }
}