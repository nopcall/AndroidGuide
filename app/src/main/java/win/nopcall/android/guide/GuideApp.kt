package win.nopcall.android.guide

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import win.nopcall.android.guide.di.Dependencies
import javax.inject.Inject

@HiltAndroidApp
class GuideApp: Application() {
    @Inject lateinit var mEngine: Dependencies.Engine
}