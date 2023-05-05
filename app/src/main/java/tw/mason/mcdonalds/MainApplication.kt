package tw.mason.mcdonalds

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import tw.mason.mcdonalds.data.PointRepository
import tw.mason.mcdonalds.data.PointRepositoryImpl
import tw.mason.mcdonalds.screen.point.PointViewModel

class MainApplication: Application() {

    private val myAppModules = module {
        single<PointRepository> { PointRepositoryImpl() }
        viewModel { PointViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainApplication)
            // Load modules
            modules(myAppModules)
        }
    }
}