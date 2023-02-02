package uz.itschool.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var active = true
    var number_x=0
    var number_0=0

    var matrix = Array(3) { IntArray(3) { -1 } }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        img0.setOnClickListener(this)
        img1.setOnClickListener(this)
        img2.setOnClickListener(this)
        img3.setOnClickListener(this)
        img4.setOnClickListener(this)
        img5.setOnClickListener(this)
        img6.setOnClickListener(this)
        img7.setOnClickListener(this)
        img8.setOnClickListener(this)
        button.text = "Player X"
        restart.setOnClickListener {
            restart()
        }

    }


    fun restart() {
        img0.isEnabled = true
        img1.isEnabled = true
        img2.isEnabled = true
        img3.isEnabled = true
        img4.isEnabled = true
        img5.isEnabled = true
        img6.isEnabled = true
        img7.isEnabled = true
        img8.isEnabled = true

        img0.setImageDrawable(null)
        img1.setImageDrawable(null)
        img2.setImageDrawable(null)
        img3.setImageDrawable(null)
        img4.setImageDrawable(null)
        img5.setImageDrawable(null)
        img6.setImageDrawable(null)
        img7.setImageDrawable(null)
        img8.setImageDrawable(null)

        active = true
        matrix = Array(3) { IntArray(3) { -1 } }

       button.text = "Player X"
        winner.text = ""
        restart.visibility = View.INVISIBLE
        textuser1.text=number_x.toString()
        textuser2.text=number_0.toString()

    }

    override fun onClick(p0: View?) {
        var img = findViewById<ImageView>(p0!!.id)
        var tag = img.tag.toString().toInt()

        var col: Int = tag / 3
        var row: Int = tag % 3
        if (matrix[col][row] == -1) {

            if (active) {
                img.setImageResource(R.drawable.x)
                active = false
                matrix[col][row] = 1
               button.text = "Player 0"
                isWinner(1)


            } else {
                img.setImageResource(R.drawable.zero)
                active = true
                matrix[col][row] = 0
               button.text = "Player X"
                isWinner(0)

            }
        }
    }


    fun isWinner(p: Int) {

        var count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[i][j] == p) {
                    count++
                }
            }
            if (count == 3) {
                winner.text = "Winner is " + p
                if (p==1){
                    number_x++
                }
                else{
                    number_0++
                }
                finishGame()
                return
            }
            count = 0
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i == j) {
                    if (matrix[i][j] == p) {
                        count++
                    }
                }
            }
            if (count == 3) {
                winner.text = "Winner is " + p
                if (p==1){
                    number_x++
                }
                else{
                    number_0++
                }
                finishGame()
                return
            }
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (i + j == 2) {
                    if (matrix[i][j] == p) {
                        count++
                    }
                }
            }
            if (count == 3) {
                winner.text = "Winner is " + p
                if (p==1){
                    number_x++
                }
                else{
                    number_0++
                }
                finishGame()
                return
            }
        }
        count = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (matrix[j][i] == p) {
                    count++
                }
            }
            if (count == 3) {
                winner.text = "Winner is " + p
                if (p==1){
                    number_x++
                }
                else{
                    number_0++
                }
                finishGame()
                return
            }
            count = 0
        }


    }

    fun finishGame() {
        img0.isEnabled = false
        img1.isEnabled = false
        img2.isEnabled = false
        img3.isEnabled = false
        img4.isEnabled = false
        img5.isEnabled = false
        img6.isEnabled = false
        img7.isEnabled = false
        img8.isEnabled = false
        restart.visibility = View.VISIBLE
    }
}