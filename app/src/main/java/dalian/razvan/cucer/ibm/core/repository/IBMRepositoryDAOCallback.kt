package dalian.razvan.cucer.ibm.core.repository

interface IBMRepositoryDAOCallback {
    fun onLoadRatesSuccess()
    fun onLoadRatesFailure(error:String)

    fun onLoadTransactionsSuccess()
    fun onLoadTransactionsFailure(error:String)
}
