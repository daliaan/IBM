package dalian.razvan.cucer.ibm.core.repository

import androidx.lifecycle.viewModelScope
import dalian.razvan.cucer.ibm.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.ibm.core.network.Result
import dalian.razvan.cucer.ibm.models.Currency
import kotlinx.coroutines.launch

class IBMRepositoryDAO(private val repository: IBMRepository): BaseViewModel() {

    private var ratesCallback: IBMRepositoryDAOCallback? = null
    private var transactionsCallback: IBMRepositoryDAOCallback? = null

    private var ratesLoaded = false
    private var transactionsLoaded = false

    fun loadRates(callback: IBMRepositoryDAOCallback) {
        viewModelScope.launch {
            when(val response = repository.loadRates()) {
                is Result.Success -> {
                    val ratesResponse = response.value
                    ratesResponse?.let {
                        repository.setRates(it)
                        val currenciesNames = arrayListOf<String>()
                        val currencies = arrayListOf<Currency>()
                        for (item in it) {
                            if (!currenciesNames.contains(item.from)) {
                                currenciesNames.add(item.from)
                                currencies.add(Currency(item.from))
                            }
                        }
                        for (rate in it) {
                            for (currency in currencies) {
                                if (rate.from == currency.name) {
                                    currency.addDirectTransaction(rate.to, rate)
                                }
                            }
                        }
                        repository.setCurrenciesNames(currenciesNames)
                        repository.setCurrencies(currencies)
                        ratesLoaded = true
                        callback.onLoadRatesSuccess()
                        ratesCallback?.onLoadRatesSuccess()
                    }
                    if (ratesResponse == null) {
                        ratesLoaded = false
                        callback.onLoadRatesFailure("Result.Success -> NULL")
                        ratesCallback?.onLoadRatesFailure("Result.Success -> NULL")
                    }
                }
                else -> {
                    ratesLoaded = false
                    callback.onLoadRatesFailure("Result.Failed")
                    ratesCallback?.onLoadRatesFailure("Result.Failed")
                }
            }
        }
    }

    fun loadTransactions(callback: IBMRepositoryDAOCallback) {
        viewModelScope.launch {
            when(val response = repository.loadTransactions()) {
                is Result.Success -> {
                    val transactionsResponse = response.value
                    transactionsResponse?.let {
                        repository.setTransactions(it)
                        transactionsLoaded = true
                        callback.onLoadTransactionsSuccess()
                        transactionsCallback?.onLoadTransactionsSuccess()
                    }
                    if (transactionsResponse == null) {
                        transactionsLoaded = false
                        callback.onLoadTransactionsFailure("Result.Success -> NULL")
                        transactionsCallback?.onLoadTransactionsFailure("Result.Success -> NULL")
                    }
                }
                else -> {
                    transactionsLoaded = false
                    callback.onLoadTransactionsFailure("Result.Failed")
                    transactionsCallback?.onLoadTransactionsFailure("Result.Failed")
                }
            }
        }
    }

    fun getRates() = repository.getRates()
    fun getTransactions() = repository.getTransactions()
    fun getCurrencies() = repository.getCurrencies()

    fun addRatesCallback(callback: IBMRepositoryDAOCallback) {
        ratesCallback = callback
        if (ratesLoaded)
            ratesCallback?.onLoadRatesSuccess()
    }
    fun addTransactionsCallback(callback: IBMRepositoryDAOCallback) {
        transactionsCallback = callback
        if (transactionsLoaded)
            transactionsCallback?.onLoadTransactionsSuccess()
    }
}
