package dalian.razvan.cucer.ibm.screens.skuValues

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragment
import dalian.razvan.cucer.ibm.core.baseClasses.RecyclerViewItemClickListener
import dalian.razvan.cucer.ibm.customViews.IBMAdapter
import dalian.razvan.cucer.ibm.models.SKUValue
import dalian.razvan.cucer.ibm.screens.transactions.TransactionsFragmentView
import kotlinx.android.synthetic.main.fragment_sku_values.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.ArrayList

class SKUValuesFragment: BaseFragment(), SKUValuesFragmentView, KoinComponent {

    private val skuValuesViewModel: SKUValuesViewModel by inject()
    private val adapter = IBMAdapter<SKUValue>()

    override fun whichLayout(): Int = R.layout.fragment_sku_values

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        list.adapter = adapter
        adapter.addItemClickListener(object: RecyclerViewItemClickListener<SKUValue> {
            override fun onItemClick(item: SKUValue) {

            }
        })

        goToTransactions.setOnClickListener {
            it.findNavController().navigate(R.id.go_to_transactions)
        }
    }

    override fun onResume() {
        super.onResume()
        skuValuesViewModel.listenForSKUValues(this as SKUValuesFragmentView)
    }

    override fun setList(skuValues: ArrayList<SKUValue>) {
        adapter.setList(skuValues)
        adapter.notifyDataSetChanged()
    }
}