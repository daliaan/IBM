package dalian.razvan.cucer.ibm.dependencyInjection

import dalian.razvan.cucer.ibm.core.network.RetrofitFactory
import dalian.razvan.cucer.ibm.core.repository.IBMRepository
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryImpl
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAO
import dalian.razvan.cucer.ibm.screens.currencies.CurrenciesViewModel
import dalian.razvan.cucer.ibm.screens.currencyDetails.CurrencyDetailsViewModel
import dalian.razvan.cucer.ibm.screens.skuValues.SKUValuesViewModel
import dalian.razvan.cucer.ibm.screens.transactions.TransactionsViewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { IBMRepositoryImpl(get()) as IBMRepository }
    single { IBMRepositoryDAO(get()) }
}

val viewModelModule = module {
    single { CurrenciesViewModel(get()) }
    single { CurrencyDetailsViewModel(get()) }
    single { SKUValuesViewModel(get()) }
    single { TransactionsViewModel(get()) }
}

val networkModule = module {
    single { RetrofitFactory.create(get()) }
}