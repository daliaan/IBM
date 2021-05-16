package dalian.razvan.cucer.ibm.screens

interface IBMRepositoryDAOCallback {
    fun onLoadRatesSuccess()
    fun onLoadRatesFailure(error:String)

    fun onLoadTransactionsSuccess()
    fun onLoadTransactionsFailure(error:String)
}
