package hu.bme.aut.mydiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationUtils
import android.widget.TextView

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val background = object : Thread() {
            override fun run() {
                try {
                    tv = findViewById(R.id.tv)
                    val animation = AnimationUtils.loadAnimation(baseContext, R.anim.splash_transition)
                    tv.startAnimation(animation)
                    Thread.sleep(1500)
                    val intent = Intent(baseContext, DiaryListActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}
