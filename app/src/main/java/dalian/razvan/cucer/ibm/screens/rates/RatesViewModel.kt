package dalian.razvan.cucer.ibm.screens.rates

import dalian.razvan.cucer.ibm.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAO
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAOCallback

class RatesViewModel(private val dao: IBMRepositoryDAO): BaseViewModel() {
    fun listenForRates(view: RatesFragmentView) {
        dao.addRatesCallback(object: IBMRepositoryDAOCallback{
            override fun onLoadRatesSuccess() {
                view.setList(dao.getRates())
            }

            override fun onLoadRatesFailure(error: String) {
                view.showPopup(error)
            }

            override fun onLoadTransactionsSuccess() {
                //TODO("Not yet implemented")
            }

            override fun onLoadTransactionsFailure(error: String) {
                //TODO("Not yet implemented")
            }

        })
    }
}