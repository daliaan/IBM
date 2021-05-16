package dalian.razvan.cucer.ibm.core.repository

import androidx.lifecycle.viewModelScope
import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragmentView
import dalian.razvan.cucer.ibm.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.ibm.core.network.Result
import dalian.razvan.cucer.ibm.models.Currency
import dalian.razvan.cucer.ibm.models.SKUValue
import dalian.razvan.cucer.ibm.screens.currencies.CurrenciesFragmentView
import kotlinx.coroutines.launch

class IBMRepositoryDAO(private val repository: IBMRepository): BaseViewModel() {

    private lateinit var navigateToSKU: SKUValue
    private lateinit var navigateToCurrency: Currency
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
                                    currency.addDirectExchangeRate(rate.to, rate)
                                }
                            }
                        }
                        for (currency in currencies) {
                            currency.calculateIndirectRates(it)
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
                        val transactionsSKU = arrayListOf<String>()
                        val skuValues = arrayListOf<SKUValue>()
                        for (item in it) {
                            if (!transactionsSKU.contains(item.sku)) {
                                transactionsSKU.add(item.sku)
                            }
                        }
                        for (sku in transactionsSKU) {
                            val skuValue = SKUValue(sku)
                            for (item in it) {
                                if (item.sku == sku) {
                                    skuValue.addTransaction(item)
                                }
                            }
                            skuValues.add(skuValue)
                        }
                        var selectedCurrency = Currency("EUR")
                        for (currency in getCurrencies()) {
                            if (currency.name == selectedCurrency.name) {
                                selectedCurrency = currency
                                break
                            }
                        }
                        for (skuValue in skuValues) {
                            skuValue.setSelectedCurrency(selectedCurrency)
                        }
                        repository.setSelectedCurrency(selectedCurrency)
                        repository.setSKUValues(skuValues)
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
    fun getSKUValues() = repository.getSKUValues()
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

    fun setSelectedCurrency(view: BaseFragmentView) {
        setSelectedCurrency(navigateToCurrency, view)
    }

    fun setSelectedCurrency(item: Currency, view: BaseFragmentView) {
        repository.setSelectedCurrency(item)
        for (skuValue in getSKUValues())
            skuValue.setSelectedCurrency(item)
        view.goBack()
    }

    fun navigateToCurrencyDetails(item: Currency) {
        navigateToCurrency = item
    }

    fun setNavigateToSKUDetails(item: SKUValue) {
        navigateToSKU = item
    }

    fun getNavigateToCurrencyDetails() = navigateToCurrency
    fun getNavigateToSkuDetails() = navigateToSKU
}
