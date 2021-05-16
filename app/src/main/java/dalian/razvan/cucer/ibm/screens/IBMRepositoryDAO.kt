package dalian.razvan.cucer.ibm.screens

import androidx.lifecycle.viewModelScope
import dalian.razvan.cucer.ibm.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.ibm.core.network.Result
import dalian.razvan.cucer.ibm.core.repository.IBMRepository
import dalian.razvan.cucer.ibm.models.Currency
import kotlinx.coroutines.launch

class IBMRepositoryDAO(private val repository: IBMRepository): BaseViewModel() {
    fun loadRates() {
        viewModelScope.launch {
            when(val response = repository.loadRates()) {
                is Result.Success -> {
                    val ratesResponse = response.value
                    ratesResponse?.let {
                        repository.setRates(it.results)
                        val currenciesNames = arrayListOf<String>()
                        val currencies = arrayListOf<Currency>()
                        for (item in it.results) {
                            if (!currenciesNames.contains(item.from)) {
                                currenciesNames.add(item.from)
                                currencies.add(Currency(item.from))
                            }
                        }
                        for (rate in it.results) {
                            for (currency in currencies) {
                                if (rate.from == currency.name) {
                                    currency.addDirectTransaction(rate.to, rate)
                                }
                            }
                        }
                        repository.setCurrenciesNames(currenciesNames)
                        repository.setCurrencies(currencies)
                    }
                    if (ratesResponse == null) {
                        //TODO show error
                    }
                }
                else -> {
                    //TODO show error
                }
            }
        }
    }

    fun loadTransactions() {
        viewModelScope.launch {
            when(val response = repository.loadTransactions()) {
                is Result.Success -> {
                    val ratesResponse = response.value
                    ratesResponse?.let {
                        repository.setTransactions(it.results)
                    }
                    if (ratesResponse == null) {
                        //TODO show error
                    }
                }
                else -> {
                    //TODO show error
                }
            }
        }
    }

    fun getRates() = repository.getRates()
    fun getTransactions() = repository.getTransactions()
    fun getCurrencies() = repository.getCurrencies()
}
