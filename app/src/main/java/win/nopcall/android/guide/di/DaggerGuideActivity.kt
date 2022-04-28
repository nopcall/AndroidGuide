package win.nopcall.android.guide.di

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import win.nopcall.android.guide.R

class DaggerGuideActivity : AppCompatActivity() {

    // ---------------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_guide)
    }
}