package dalian.razvan.cucer.ibm.screens.currencyDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragment
import dalian.razvan.cucer.ibm.core.baseClasses.RecyclerViewItemClickListener
import dalian.razvan.cucer.ibm.customViews.IBMAdapter
import dalian.razvan.cucer.ibm.models.Currency
import dalian.razvan.cucer.ibm.models.Rate
import dalian.razvan.cucer.ibm.models.SKUValue
import kotlinx.android.synthetic.main.fragment_currency_detalis.*
import kotlinx.android.synthetic.main.fragment_sku_values.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class CurrencyDetailsFragment: BaseFragment(), CurrencyDetailsFragmentView, KoinComponent {

    private val currencyDetailsViewModel: CurrencyDetailsViewModel by inject()
    private val directRatesAdapter = IBMAdapter<Rate>()
    private val indirectRatesAdapter = IBMAdapter<Rate>()

    override fun whichLayout(): Int = R.layout.fragment_currency_detalis

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        direct_rates.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        direct_rates.adapter = directRatesAdapter
        directRatesAdapter.addItemClickListener(object: RecyclerViewItemClickListener<Rate> {
            override fun onItemClick(item: Rate) {

            }
        })

        indirect_rates.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        indirect_rates.adapter = indirectRatesAdapter
        indirectRatesAdapter.addItemClickListener(object: RecyclerViewItemClickListener<Rate> {
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

        directRatesAdapter.resetList(currency.getDirectRates())
        indirectRatesAdapter.resetList(currency.getIndirectRates())
    }

    override fun goBack() {
        super.goBack()
        findNavController().popBackStack(R.id.go_to_currencies, true)
    }
}