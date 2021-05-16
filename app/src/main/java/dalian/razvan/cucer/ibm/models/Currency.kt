package dalian.razvan.cucer.ibm.models

import android.util.Log
import dalian.razvan.cucer.ibm.core.baseClasses.BaseModel

class Currency(val name: String): BaseModel() {

    override fun getObjectType(): Companion.Type = Companion.Type.CURRENCY

    private val directExchangeRates = arrayListOf<String>()
    private val directRates = arrayListOf<Rate>()
    private val indirectExchangeRates = arrayListOf<String>()
    private val indirectRates = arrayListOf<Rate>()

    fun addDirectExchangeRate(currency: String, rate: Rate) {
        directExchangeRates.add(currency)
        directRates.add(rate)
    }

    private fun hasDirectExchangeRate(currency: String): Boolean {
        for (item in directExchangeRates) {
            if (item == currency)
                return true
        }
        return false
    }

    fun getDirectExchangeRate(currency: String): Rate? {
        if (directExchangeRates.contains(currency)) {
            for (rate in directRates) {
                if (rate.to == currency)
                    return rate
            }
        }
        return null
    }

    fun calculateIndirectRates(allRates: ArrayList<Rate>) {
        val tempRates = arrayListOf<Rate>()
        tempRates.addAll(allRates)
        for (rate in tempRates) {
            if (rate.from == name)
                tempRates.remove(rate)
            else if (rate.to == name) {
                tempRates.remove(rate)
            }
        }
        for (rate in tempRates) {
            for (directRate in directRates) {
                if (directRate.to == rate.from) {
                    if (!hasDirectExchangeRate(rate.to)) {
                        indirectRates.add(Rate(directRate.from, rate.to, directRate.rate * rate.rate))
                        indirectExchangeRates.add(rate.to)
                    }
                }
            }
        }
        Log.e("indirectRates", indirectRates.toString())
    }

    fun getIndirectChangeRates(currency: String): Rate? {
        if (indirectExchangeRates.contains(currency)) {
            for (rate in indirectRates) {
                if (rate.to == currency)
                    return rate
            }
        }
        return null
    }
}