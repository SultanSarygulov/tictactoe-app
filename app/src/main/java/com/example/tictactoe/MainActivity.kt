package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var turn = 0
    val redSquare = R.drawable.soft_square_red
    val blueSquare = R.drawable.soft_square_blue
    val blackSquare = R.drawable.soft_square_black


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()

        binding.againButton.setOnClickListener {
            startAgain()
        }

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
            Log.d("TicTac", "${item.id}")

            item.setOnClickListener{ makeColored(it as TextView) }

        }
    }

    private fun makeColored(view: TextView){

        var currentSquare = blackSquare
        var sign = ""
        var player1square = blackSquare
        var player2square = blackSquare

        if (turn % 2 == 0){
            currentSquare = redSquare
            sign = "X"

            player1square = blackSquare
            player2square = blueSquare
        } else {
            currentSquare = blueSquare
            sign = "O"

            player1square = redSquare
            player2square = blackSquare
        }
        if (view.text == ""){

            when (view.id) {
                R.id.tile_1_1 -> {
                    view.setBackgroundResource(currentSquare)
                    view.text = sign
                }
                R.id.tile_2_1 -> {
                    view.setBackgroundResource(currentSquare)
                    view.text = sign
                }
                R.id.tile_3_1 -> {
                    view.setBackgroundResource(currentSquare)
                    view.text = sign
                }
                R.id.tile_1_2 -> {
                    view.setBackgroundResource(currentSquare)
                    view.text = sign
                }
                R.id.tile_2_2 -> {
                    view.setBackgroundResource(currentSquare)
                    view.text = sign
                }
                R.id.tile_3_2 -> {
                    view.setBackgroundResource(currentSquare)
                    view.text = sign
                }
                R.id.tile_1_3 -> {
                    view.setBackgroundResource(currentSquare)
                    view.text = sign
                }
                R.id.tile_2_3 -> {
                    view.setBackgroundResource(currentSquare)
                    view.text = sign
                }
                R.id.tile_3_3 -> {
                    view.setBackgroundResource(currentSquare)
                    view.text = sign
                }
            }

            binding.player1.setBackgroundResource(player1square)
            binding.player2.setBackgroundResource(player2square)

            turn++
        }



    }

    private fun startAgain() {
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

        clickableViews.forEach{
            it.text = ""
            it.setBackgroundResource(blackSquare)
        }
        binding.player1.setBackgroundResource(redSquare)
        binding.player2.setBackgroundResource(blackSquare)
        turn = 0
    }

}
