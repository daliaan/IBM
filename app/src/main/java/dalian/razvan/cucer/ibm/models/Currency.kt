package dalian.razvan.cucer.ibm.models

import android.util.Log
import dalian.razvan.cucer.ibm.core.baseClasses.BaseModel

class Currency(val name: String): BaseModel() {

    override fun getObjectType(): Companion.Type = Companion.Type.CURRENCY

    private val exchangeRates = arrayListOf<String>()
    private val rates = arrayListOf<Rate>()

    fun addExchangeRate(currency: String, rate: Rate) {
        exchangeRates.add(currency)
        rates.add(rate)
    }

    private fun hasExchangeRate(currency: String): Boolean {
        for (item in exchangeRates) {
            if (item == currency)
                return true
        }
        return false
    }

    fun getExchangeRate(currency: String): Rate? {
        if (exchangeRates.contains(currency)) {
            for (rate in rates) {
                if (rate.to == currency)
                    return rate
            }
        }
        return null
    }

    fun calculateMissingRates(allRates: ArrayList<Rate>, totalNumberOfRatesRequired: Int) {
        val tempRates = arrayListOf<Rate>()
        tempRates.addAll(allRates)
        val tempRatesToRemove = arrayListOf<Rate>()
        val indirectRates = arrayListOf<Rate>()
        val indirectExchangeRates = arrayListOf<String>()
        for (rate in tempRates) {
            if (rate.from == name)
                tempRatesToRemove.add(rate)
            else if (rate.to == name) {
                tempRatesToRemove.add(rate)
            }
        }
        tempRates.removeAll(tempRatesToRemove)
        tempRatesToRemove.clear()
        for (rate in tempRates) {
            for (directRate in rates) {
                if (directRate.to == rate.from) {
                    if (!hasExchangeRate(rate.to)) {
                        indirectRates.add(Rate(directRate.from, rate.to, directRate.rate * rate.rate))
                        indirectExchangeRates.add(rate.to)
                    }
                }
            }
        }
        rates.addAll(indirectRates)
        exchangeRates.addAll(indirectExchangeRates)
        if (rates.size + indirectRates.size != totalNumberOfRatesRequired) {
            calculateMissingRates(allRates, totalNumberOfRatesRequired)
        }
        Log.e("rates", rates.toString())
    }

    fun getRates() = rates
}