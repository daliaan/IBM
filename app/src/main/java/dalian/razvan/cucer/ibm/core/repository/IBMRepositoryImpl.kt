package dalian.razvan.cucer.ibm.core.repository

import android.util.Log
import dalian.razvan.cucer.ibm.core.network.API
import dalian.razvan.cucer.ibm.core.network.Result
import dalian.razvan.cucer.ibm.core.network.model.APIResponse
import dalian.razvan.cucer.ibm.core.network.safeApiCall
import dalian.razvan.cucer.ibm.models.Currency
import dalian.razvan.cucer.ibm.models.Rate
import dalian.razvan.cucer.ibm.models.SKUValue
import dalian.razvan.cucer.ibm.models.Transaction

class IBMRepositoryImpl(private val api: API): IBMRepository {

    private lateinit var selectedCurrency: Currency
    private val rates = arrayListOf<Rate>()
    private val transactions = arrayListOf<Transaction>()
    private val skuValues = arrayListOf<SKUValue>()
    private val currencies = arrayListOf<Currency>()
    private val currenciesNames = arrayListOf<String>()

    override suspend fun loadRates(): Result<ArrayList<Rate>?> = safeApiCall {
        api.getRates()
    }

    override suspend fun loadTransactions(): Result<ArrayList<Transaction>?> = safeApiCall {
        api.getTransactions()
    }

    override fun setRates(list: ArrayList<Rate>) {
        Log.e(javaClass.simpleName, "rates $list")
        this.rates.addAll(list)
    }

    override fun setTransactions(list: ArrayList<Transaction>) {
        Log.e(javaClass.simpleName, "transactions $list")
        this.transactions.addAll(list)
    }

    override fun setSKUValues(list: ArrayList<SKUValue>) {
        Log.e(javaClass.simpleName, "skuValues $list")
        this.skuValues.addAll(list)
    }

    override fun setCurrencies(list: ArrayList<Currency>) {
        Log.e(javaClass.simpleName, "currencies $list")
        this.currencies.addAll(list)
    }

    override fun setCurrenciesNames(list: ArrayList<String>) {
        this.currenciesNames.addAll(list)
    }

    override fun setSelectedCurrency(item: Currency) {
        this.selectedCurrency = item
    }

    override fun getRates(): ArrayList<Rate> = rates
    override fun getSKUValues(): ArrayList<SKUValue> =skuValues
    override fun getTransactions(): ArrayList<Transaction> = transactions
    override fun getCurrencies(): ArrayList<Currency> = currencies
    override fun getCurrenciesNames(list: ArrayList<String>) = currenciesNames
    override fun getSelectedCurrency(): Currency = selectedCurrency
}