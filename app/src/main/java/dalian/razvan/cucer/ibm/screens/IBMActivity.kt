package dalian.razvan.cucer.ibm.screens

import android.os.Bundle
import androidx.activity.viewModels
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseActivity

class IBMActivity: BaseActivity() {

    val dao: IBMRepositoryDAO by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ibm)
    }

    override fun onResume() {
        super.onResume()
        dao.loadRates()
        dao.loadTransactions()
    }
}