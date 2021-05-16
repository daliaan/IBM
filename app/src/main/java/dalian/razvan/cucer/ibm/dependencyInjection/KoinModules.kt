package dalian.razvan.cucer.ibm.dependencyInjection

import dalian.razvan.cucer.ibm.core.network.RetrofitFactory
import dalian.razvan.cucer.ibm.core.repository.IBMRepository
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { IBMRepositoryImpl() as IBMRepository }
}

val viewModelModule = module {
}

val networkModule = module {
    single { RetrofitFactory.create(get()) }
}