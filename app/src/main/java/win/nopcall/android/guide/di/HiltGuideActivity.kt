package win.nopcall.android.guide.di

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import win.nopcall.android.guide.R
import javax.inject.Inject

@AndroidEntryPoint
class HiltGuideActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName

    @Inject
    lateinit var engine: Dependencies.Engine

    // ---------------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "engine: ${engine.name} size: ${engine.size}")
    }
}