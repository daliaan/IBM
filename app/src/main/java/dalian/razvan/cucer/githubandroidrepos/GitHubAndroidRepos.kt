package dalian.razvan.cucer.githubandroidrepos

import android.app.Application
import dalian.razvan.cucer.githubandroidrepos.dependencyInjection.networkModule
import dalian.razvan.cucer.githubandroidrepos.dependencyInjection.repositoryModule
import dalian.razvan.cucer.githubandroidrepos.dependencyInjection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GitHubAndroidRepos: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@GitHubAndroidRepos)
            modules(listOf(viewModelModule, repositoryModule, networkModule))
        }
    }
}