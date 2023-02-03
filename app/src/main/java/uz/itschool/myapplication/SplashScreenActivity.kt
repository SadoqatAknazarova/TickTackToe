package uz.itschool.myapplication

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity: AppCompatActivity(), View.OnClickListener {

    var matrix = Array(3) { IntArray(3) { -1 } }

    var anim: Animation = AnimationUtils.loadAnimation(this,R.anim.set)
    var anim1: Animation = AnimationUtils.loadAnimation(this,R.anim.set)

    var btn2=findViewById<Button>(R.id.button2)
    var btn3=findViewById<Button>(R.id.button3)

        btn2.startAnimation(anim)
        anim.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {

                btn3.startAnimation(anim)
            }

            override fun onAnimationRepeat(p0: Animation?) {

            }


    })
    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}
