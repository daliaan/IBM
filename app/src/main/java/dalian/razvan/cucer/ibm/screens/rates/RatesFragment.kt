package dalian.razvan.cucer.ibm.screens.rates

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragment
import dalian.razvan.cucer.ibm.core.baseClasses.RecyclerViewItemClickListener
import dalian.razvan.cucer.ibm.customViews.IBMAdapter
import dalian.razvan.cucer.ibm.models.Rate
import kotlinx.android.synthetic.main.fragment_rates.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.util.ArrayList

class RatesFragment: BaseFragment(), RatesFragmentView, KoinComponent {

    private val ratesViewModel: RatesViewModel by inject()
    private val adapter = IBMAdapter<Rate>()

    override fun whichLayout(): Int = R.layout.fragment_rates

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        list.adapter = adapter
        adapter.addItemClickListener(object: RecyclerViewItemClickListener<Rate> {
            override fun onItemClick(item: Rate) {

            }
        })
    }

    override fun onResume() {
        super.onResume()
        ratesViewModel.listenForRates(this as RatesFragmentView)
    }

    override fun setList(rates: ArrayList<Rate>) {
        adapter.resetList(rates)
        adapter.notifyDataSetChanged()
    }
}