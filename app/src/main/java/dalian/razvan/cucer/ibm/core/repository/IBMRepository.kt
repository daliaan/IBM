package dalian.razvan.cucer.ibm.core.repository

import dalian.razvan.cucer.ibm.core.network.Result
import dalian.razvan.cucer.ibm.core.network.model.APIResponse
import dalian.razvan.cucer.ibm.models.Currency
import dalian.razvan.cucer.ibm.models.Rate
import dalian.razvan.cucer.ibm.models.Transaction

interface IBMRepository {

    suspend fun loadRates(): Result<APIResponse<Rate>?>
    suspend fun loadTransactions(): Result<APIResponse<Transaction>?>

    fun setRates(list: ArrayList<Rate>)
    fun setTransactions(list: ArrayList<Transaction>)
    fun setCurrencies(list: ArrayList<Currency>)

    fun getRates(): ArrayList<Rate>
    fun getTransactions(): ArrayList<Transaction>
    fun getCurrencies(): ArrayList<Currency>
}