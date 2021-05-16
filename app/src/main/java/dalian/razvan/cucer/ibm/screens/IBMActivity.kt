package dalian.razvan.cucer.ibm.screens

import android.os.Bundle
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseActivity
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAO
import dalian.razvan.cucer.ibm.core.repository.IBMRepositoryDAOCallback
import org.koin.core.KoinComponent
import org.koin.core.inject

class IBMActivity: BaseActivity(), KoinComponent, IBMRepositoryDAOCallback {

    val dao by inject<IBMRepositoryDAO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ibm)
    }

    override fun onResume() {
        super.onResume()
        dao.loadRates(this)
        dao.loadTransactions(this)
    }

    override fun onLoadRatesSuccess() {

    }

    override fun onLoadRatesFailure(error: String) {

    }

    override fun onLoadTransactionsSuccess() {

    }

    override fun onLoadTransactionsFailure(error: String) {

    }
}