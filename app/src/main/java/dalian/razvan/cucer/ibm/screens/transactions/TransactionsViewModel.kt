package dalian.razvan.cucer.ibm.screens.transactions

import dalian.razvan.cucer.ibm.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAO
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAOCallback

class TransactionsViewModel(private val dao: IBMRepositoryDAO): BaseViewModel() {
    fun listenForTransactions(view: TransactionsFragmentView) {
        dao.addTransactionsCallback(object: IBMRepositoryDAOCallback {
            override fun onLoadRatesSuccess() {
                //TODO("Not yet implemented")
            }

            override fun onLoadRatesFailure(error: String) {
                //TODO("Not yet implemented")
            }

            override fun onLoadTransactionsSuccess() {
                view.setList(dao.getTransactions())
            }

            override fun onLoadTransactionsFailure(error: String) {
                view.showPopup(error)
            }
        })
    }
}