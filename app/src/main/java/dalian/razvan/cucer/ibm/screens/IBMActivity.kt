package dalian.razvan.cucer.ibm.screens

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseActivity
import dalian.razvan.cucer.ibm.core.baseClasses.RecyclerViewItemClickListener
import dalian.razvan.cucer.ibm.customViews.IBMAdapter
import dalian.razvan.cucer.ibm.models.Rate
import kotlinx.android.synthetic.main.activity_ibm.*
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