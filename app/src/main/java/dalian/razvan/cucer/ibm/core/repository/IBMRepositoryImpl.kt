package dalian.razvan.cucer.ibm.core.repository

import dalian.razvan.cucer.ibm.core.network.API
import dalian.razvan.cucer.ibm.core.network.Result
import dalian.razvan.cucer.ibm.core.network.model.APIResponse
import dalian.razvan.cucer.ibm.core.network.safeApiCall
import dalian.razvan.cucer.ibm.models.Currency
import dalian.razvan.cucer.ibm.models.Rate
import dalian.razvan.cucer.ibm.models.Transaction

class IBMRepositoryImpl(private val api: API): IBMRepository {

    private val rates = arrayListOf<Rate>()
    private val transactions = arrayListOf<Transaction>()
    private val currencies = arrayListOf<Currency>()

    override suspend fun loadRates(): Result<APIResponse<Rate>?> = safeApiCall {
        api.getRates()
    }

    override suspend fun loadTransactions(): Result<APIResponse<Transaction>?> = safeApiCall {
        api.getTransactions()
    }

    override fun setRates(list: ArrayList<Rate>) {
        this.rates.addAll(list)
    }

    override fun setTransactions(list: ArrayList<Transaction>) {
        this.transactions.addAll(list)
    }

    override fun setCurrencies(list: ArrayList<Currency>) {
        this.currencies.addAll(list)
    }

    override fun getRates(): ArrayList<Rate> = rates
    override fun getTransactions(): ArrayList<Transaction> = transactions
    override fun getCurrencies(): ArrayList<Currency> = currencies
}