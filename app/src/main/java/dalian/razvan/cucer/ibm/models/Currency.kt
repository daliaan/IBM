package dalian.razvan.cucer.ibm.models

class Currency(val name: String) {
    private val directTransactions = arrayListOf<String>()
    private val directRates = arrayListOf<Rate>()

    fun addDirectTransaction(currency: String, rate: Rate) {
        directTransactions.add(currency)
        directRates.add(rate)
    }

    fun hasDirectTransaction(currency: String): Boolean {
        for (item in directTransactions) {
            if (item == currency)
                return true
        }
        return false
    }

    fun getDirectTransactionRate(currency: String): Rate? {
        for (i in 0 until directTransactions.size) {
            if (directTransactions[i] == currency)
                return directRates[i]
        }
        return null
    }
}