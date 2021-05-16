package dalian.razvan.cucer.ibm.screens.transactions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragment
import dalian.razvan.cucer.ibm.core.baseClasses.RecyclerViewItemClickListener
import dalian.razvan.cucer.ibm.customViews.IBMAdapter
import dalian.razvan.cucer.ibm.models.Transaction
import kotlinx.android.synthetic.main.fragment_transactions.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.ArrayList

class TransactionsFragment: BaseFragment(), TransactionsFragmentView, KoinComponent {

    private val transactionsViewModel: TransactionsViewModel by inject()
    private val adapter = IBMAdapter<Transaction>()

    override fun whichLayout(): Int = R.layout.fragment_transactions

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        list.adapter = adapter
        adapter.addItemClickListener(object: RecyclerViewItemClickListener<Transaction>{
            override fun onItemClick(item: Transaction) {

            }
        })
    }

    override fun onResume() {
        super.onResume()
        val skuValue = transactionsViewModel.getSKUDetails()
        adapter.resetList(skuValue.getTransactions())
    }
}