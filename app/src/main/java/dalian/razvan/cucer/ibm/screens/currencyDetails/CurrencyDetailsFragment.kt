package dalian.razvan.cucer.ibm.screens.currencyDetails

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragment
import dalian.razvan.cucer.ibm.core.baseClasses.RecyclerViewItemClickListener
import dalian.razvan.cucer.ibm.customViews.IBMAdapter
import dalian.razvan.cucer.ibm.models.Rate
import kotlinx.android.synthetic.main.fragment_currency_detalis.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class CurrencyDetailsFragment: BaseFragment(), CurrencyDetailsFragmentView, KoinComponent {

    private val currencyDetailsViewModel: CurrencyDetailsViewModel by inject()
    private val ratesAdapter = IBMAdapter<Rate>()

    override fun whichLayout(): Int = R.layout.fragment_currency_detalis

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        list.adapter = ratesAdapter
        ratesAdapter.addItemClickListener(object: RecyclerViewItemClickListener<Rate> {
            override fun onItemClick(item: Rate) {

            }
        })

        select_currency.setOnClickListener {
            currencyDetailsViewModel.setSelectedCurrency(this@CurrencyDetailsFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        val currency = currencyDetailsViewModel.getCurrency()

        ratesAdapter.resetList(currency.getRates())
    }

    override fun goBack() {
        findNavController().popBackStack(R.id.go_to_currencies, true)
        super.goBack()
    }
}