package win.nopcall.android.guide.di

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.hilt.migration.DisableInstallInCheck
import win.nopcall.android.guide.GuideApp
import win.nopcall.android.guide.R
import javax.inject.Inject
import javax.inject.Singleton

// -------------------------------------------------------------------------------------------------
// dependencies of dagger guide activity
class DaggerGuideViewModel @Inject constructor(
    private val userRepo: UserRepo
) : ViewModel() {}

class UserRepo @Inject constructor(
    private val localSource: LocalSource,
    private val remoteSource: RemoteSource
)

class LocalSource @Inject constructor() {}
class RemoteSource @Inject constructor(
    private val netService: NetService
) {}

@Singleton
class NetService(val timeout: Int)

@DisableInstallInCheck
@Module
class NetServiceModule {
    @Provides
    fun provideNetService(): NetService {
        return NetService(9)
    }
}

// -------------------------------------------------------------------------------------------------
@Subcomponent
interface TransientComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): TransientComponent
    }

    fun inject(activity: DaggerGuideActivity)
}

@Module(subcomponents = [TransientComponent::class])
class SubcomponentsModule {}


// -------------------------------------------------------------------------------------------------
// activity of UI
class DaggerGuideActivity : AppCompatActivity() {
    @Inject lateinit var mDaggerViewModel: DaggerGuideViewModel

    // ---------------------------------------------------------------------------------------------
    // life cycle methods
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as GuideApp).appComponent.transientComponent().create().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_guide)
    }
}