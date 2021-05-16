package dalian.razvan.cucer.ibm.screens.skuValues

import dalian.razvan.cucer.ibm.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAO
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAOCallback

class SKUValuesViewModel(private val dao: IBMRepositoryDAO): BaseViewModel() {
    fun listenForSKUValues(view: SKUValuesFragmentView) {
        dao.addTransactionsCallback(object: IBMRepositoryDAOCallback {
            override fun onLoadRatesSuccess() {
                //TODO("Not yet implemented")
            }

            override fun onLoadRatesFailure(error: String) {
                //TODO("Not yet implemented")
            }

            override fun onLoadTransactionsSuccess() {
                view.setList(dao.getSKUValues())
            }

            override fun onLoadTransactionsFailure(error: String) {
                view.showPopup(error)
            }
        })
    }
}