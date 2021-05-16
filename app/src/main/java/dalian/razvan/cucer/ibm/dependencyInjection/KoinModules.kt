package dalian.razvan.cucer.ibm.dependencyInjection

import dalian.razvan.cucer.ibm.core.network.RetrofitFactory
import org.koin.dsl.module

val repositoryModule = module {
}

val viewModelModule = module {
}

val networkModule = module {
    single { RetrofitFactory.create(get()) }
}