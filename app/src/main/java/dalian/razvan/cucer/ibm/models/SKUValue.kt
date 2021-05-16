package dalian.razvan.cucer.ibm.models

import dalian.razvan.cucer.ibm.core.baseClasses.BaseModel
import java.math.RoundingMode
import java.text.DecimalFormat

class SKUValue(val sku: String): BaseModel() {

    override fun getObjectType(): Companion.Type = Companion.Type.SKU_VALUE

    private val transactions = arrayListOf<Transaction>()
    private var totalAmountInSelectedCurrency = 0.0
    private var selectedCurrency: Currency = Currency("EUR")
    private var decimalFormat = DecimalFormat("#,###.00")

    init {
        decimalFormat.roundingMode = RoundingMode.HALF_EVEN
    }

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun setSelectedCurrency(currency: Currency) {
        selectedCurrency = currency
    }

    fun getSelectedCurrency() = selectedCurrency.name

    fun getTotalAmount(): String {
        totalAmountInSelectedCurrency = 0.0

        for (transaction in transactions) {
            if (transaction.currency == selectedCurrency.name) {
                totalAmountInSelectedCurrency += transaction.amount
            } else {
                val transactionRate = selectedCurrency.getDirectExchangeRate(transaction.currency)
                if (transactionRate != null) {
                    transactionRate?.let {
                        totalAmountInSelectedCurrency += transaction.amount * it.rate
                    }
                } else {
                    selectedCurrency.getIndirectChangeRates(transaction.currency)?.let {
                        totalAmountInSelectedCurrency += transaction.amount * it.rate
                    }
                }
            }
        }

        return decimalFormat.format(totalAmountInSelectedCurrency)
    }
}