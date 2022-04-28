package win.nopcall.android.guide

import android.app.Application
import dagger.Component
import win.nopcall.android.guide.di.NetServiceModule
import win.nopcall.android.guide.di.SubcomponentsModule
import win.nopcall.android.guide.di.TransientComponent
import javax.inject.Singleton

// Dagger way of DI
@Singleton
@Component(modules = [NetServiceModule::class, SubcomponentsModule::class])
interface ApplicationComponent {
    fun transientComponent(): TransientComponent.Factory
}

// @HiltAndroidApp
class GuideApp: Application() {
    // hilt
    // @Inject lateinit var mEngine: Dependencies.Engine

    // dagger way of DI
    val appComponent = DaggerApplicationComponent.create()
}