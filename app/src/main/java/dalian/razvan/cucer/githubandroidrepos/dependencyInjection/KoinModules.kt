package dalian.razvan.cucer.githubandroidrepos.dependencyInjection

import dalian.razvan.cucer.githubandroidrepos.core.network.RetrofitFactory
import dalian.razvan.cucer.githubandroidrepos.core.repository.ReposRepository
import dalian.razvan.cucer.githubandroidrepos.core.repository.ReposRepositoryImpl
import dalian.razvan.cucer.githubandroidrepos.screens.repoDetails.RepoDetailsViewModel
import dalian.razvan.cucer.githubandroidrepos.screens.reposList.ReposListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { ReposRepositoryImpl(get()) as ReposRepository }
}

val viewModelModule = module {
    viewModel { ReposListViewModel(get()) }
    viewModel { RepoDetailsViewModel(get()) }
}

val networkModule = module {
    single { RetrofitFactory.create(get()) }
}