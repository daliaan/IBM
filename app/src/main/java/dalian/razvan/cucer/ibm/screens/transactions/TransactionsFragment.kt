package dalian.razvan.cucer.ibm.screens.transactions

import androidx.fragment.app.viewModels
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragment

class TransactionsFragment: BaseFragment(), TransactionsFragmentView {

    val transactionsViewModel: TransactionsViewModel by viewModels()

    override fun whichLayout(): Int = R.layout.fragment_transactions
}