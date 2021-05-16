package dalian.razvan.cucer.ibm.models

class Currency(val name: String) {
    private val directTransactions = arrayListOf<Currency>()
    private val directRates = arrayListOf<Rate>()

    fun addDirectTransaction(currency: Currency, rate: Rate) {
        directTransactions.add(currency)
        directRates.add(rate)
    }

    fun hasDirectTransaction(currency: Currency): Boolean {
        for (item in directTransactions) {
            if (item.name == currency.name)
                return true
        }
        return false
    }

    fun getDirectTransactionRate(currency: Currency): Rate? {
        for (i in 0 until directTransactions.size) {
            if (directTransactions[i].name == currency.name)
                return directRates[i]
        }
        return null
    }
}