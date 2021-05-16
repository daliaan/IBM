package dalian.razvan.cucer.ibm.screens.currencyDetails

import dalian.razvan.cucer.ibm.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAO
import dalian.razvan.cucer.ibm.models.Currency

class CurrencyDetailsViewModel(private val dao: IBMRepositoryDAO): BaseViewModel() {
    fun setSelectedCurrency(view: CurrencyDetailsFragmentView) {
        dao.setSelectedCurrency(view)
    }

    fun getCurrency() = dao.getNavigateToCurrencyDetails()

}