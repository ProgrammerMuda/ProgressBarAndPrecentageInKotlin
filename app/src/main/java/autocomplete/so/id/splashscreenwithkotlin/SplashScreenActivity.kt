package autocomplete.so.id.splashscreenwithkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import org.w3c.dom.Text

class SplashScreenActivity : AppCompatActivity() {

    internal var Pstatus = 0
    private var handler = Handler()
    internal lateinit var tv: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val res = resources
        val drawable = res.getDrawable(R.drawable.circural)
        val progressBar = findViewById<View>(R.id.circularProgressbar) as ProgressBar
        progressBar.progress = 0
        progressBar.secondaryProgress = 100
        progressBar.max = 100
        progressBar.progressDrawable = drawable

        tv = findViewById<View>(R.id.tv) as TextView
        Thread(Runnable {

            while (Pstatus < 100){
                Pstatus += 1
                handler.post{
                    progressBar.progress = Pstatus
                    tv.text = Pstatus.toString() + "%"
                }

                try{
                    Thread.sleep(16)

                }catch (e: InterruptedException){
                    e.printStackTrace()
                }

            }






        }).start()







    }
}


