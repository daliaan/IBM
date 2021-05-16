package dalian.razvan.cucer.ibm.core.repository

import dalian.razvan.cucer.ibm.core.network.Result
import dalian.razvan.cucer.ibm.core.network.model.APIResponse
import dalian.razvan.cucer.ibm.models.Currency
import dalian.razvan.cucer.ibm.models.Rate
import dalian.razvan.cucer.ibm.models.SKUValue
import dalian.razvan.cucer.ibm.models.Transaction

interface IBMRepository {

    suspend fun loadRates(): Result<ArrayList<Rate>?>
    suspend fun loadTransactions(): Result<ArrayList<Transaction>?>

    fun setRates(list: ArrayList<Rate>)
    fun setTransactions(list: ArrayList<Transaction>)
    fun setSKUValues(list: ArrayList<SKUValue>)
    fun setCurrencies(list: ArrayList<Currency>)
    fun setCurrenciesNames(list: ArrayList<String>)
    fun setSelectedCurrency(item: Currency)

    fun getRates(): ArrayList<Rate>
    fun getSKUValues(): ArrayList<SKUValue>
    fun getTransactions(): ArrayList<Transaction>
    fun getCurrencies(): ArrayList<Currency>
    fun getCurrenciesNames(list: ArrayList<String>): ArrayList<String>
    fun getSelectedCurrency(): Currency
}