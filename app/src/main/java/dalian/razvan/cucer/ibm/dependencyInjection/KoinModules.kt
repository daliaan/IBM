package dalian.razvan.cucer.ibm.dependencyInjection

import dalian.razvan.cucer.ibm.core.network.RetrofitFactory
import dalian.razvan.cucer.ibm.core.repository.IBMRepository
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryImpl
import dalian.razvan.cucer.ibm.screens.IBMRepositoryDAO
import org.koin.dsl.module

val repositoryModule = module {
    single { IBMRepositoryImpl(get()) as IBMRepository }
    single { IBMRepositoryDAO(get()) }
}

val viewModelModule = module {
}

val networkModule = module {
    single { RetrofitFactory.create(get()) }
}