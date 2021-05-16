package dalian.razvan.cucer.ibm

import android.app.Application
import dalian.razvan.cucer.ibm.dependencyInjection.networkModule
import dalian.razvan.cucer.ibm.dependencyInjection.repositoryModule
import dalian.razvan.cucer.ibm.dependencyInjection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class IBM: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@IBM)
            modules(listOf(viewModelModule, repositoryModule, networkModule))
        }
    }
}