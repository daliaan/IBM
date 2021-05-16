package dalian.razvan.cucer.ibm.screens.currencies

import dalian.razvan.cucer.ibm.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAO
import dalian.razvan.cucer.ibm.models.Currency

class CurrenciesViewModel(private val dao: IBMRepositoryDAO): BaseViewModel() {
    fun getCurrencies(): ArrayList<Currency> = dao.getCurrencies()
    fun navidateToCurrencyDetails(item: Currency) {
        dao.navigateToCurrencyDetails(item)
    }
}