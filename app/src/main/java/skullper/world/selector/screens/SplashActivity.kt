package skullper.world.selector.screens

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.startActivity

/**
 * Created by skullper on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity<MainActivity>()
        finish()
    }
}