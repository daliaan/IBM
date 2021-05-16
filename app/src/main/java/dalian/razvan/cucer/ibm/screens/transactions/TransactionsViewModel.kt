package dalian.razvan.cucer.ibm.screens.transactions

import dalian.razvan.cucer.ibm.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAO
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAOCallback

class TransactionsViewModel(private val dao: IBMRepositoryDAO): BaseViewModel() {
    fun getSKUDetails() = dao.getNavigateToSkuDetails()
}