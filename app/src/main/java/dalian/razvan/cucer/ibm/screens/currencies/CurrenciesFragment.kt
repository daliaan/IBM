package dalian.razvan.cucer.ibm.screens.currencies

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragment
import dalian.razvan.cucer.ibm.core.baseClasses.RecyclerViewItemClickListener
import dalian.razvan.cucer.ibm.customViews.IBMAdapter
import dalian.razvan.cucer.ibm.models.Currency
import kotlinx.android.synthetic.main.fragment_currencies.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class CurrenciesFragment: BaseFragment(), CurrenciesFragmentView, KoinComponent {

    private val currenciesViewModel: CurrenciesViewModel by inject()
    private val adapter = IBMAdapter<Currency>()

    override fun whichLayout(): Int = R.layout.fragment_currencies

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        list.adapter = adapter
        adapter.addItemClickListener(object: RecyclerViewItemClickListener<Currency> {
            override fun onItemClick(item: Currency) {
                currenciesViewModel.navidateToCurrencyDetails(item)
                findNavController().navigate(R.id.go_to_currency_details)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        adapter.resetList(currenciesViewModel.getCurrencies())
        adapter.notifyDataSetChanged()
    }
}