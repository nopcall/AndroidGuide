package win.nopcall.android.guide.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

class Dependencies {
    interface Engine {
        var name: String
        var size: Int
        var weight: Int
        var power: Float

        fun run()
    }

    @Singleton
    class DummyEngineImpl @Inject constructor() : Engine {
        override var name: String = "dummy"
        override var size: Int = 99
        override var weight: Int = 100
        override var power: Float = 101f
        override fun run() {
            TODO("Not yet implemented")
        }
    }

    @ActivityScoped
    class ElectricEngineImpl constructor(
        override var name: String,
        override var size: Int,
        override var weight: Int,
        override var power: Float
    ) : Engine {
        override fun run() {
            TODO("Not yet implemented")
        }
    }

    @ActivityScoped
    class GasoilEngineImpl constructor(
        override var name: String,
        override var size: Int,
        override var weight: Int,
        override var power: Float
    ) : Engine {
        override fun run() {
            TODO("Not yet implemented")
        }
    }

    @Module
    @InstallIn(ActivityComponent::class)
    abstract class DummyEngineModule {
        @Binds
        abstract fun bindEngine(engineImpl: DummyEngineImpl): Engine
    }

    // custom provide way for dependencies
    @Module
    @InstallIn(SingletonComponent::class)
    object EngineModule {

        @Provides
        fun provideEngine(): Engine {
            val a = 1
            return GasoilEngineImpl("GasoilEngine", 1, 2, 3f)
        }
    }
}