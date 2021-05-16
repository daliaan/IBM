package dalian.razvan.cucer.ibm.screens.currencyDetails

import androidx.fragment.app.viewModels
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragment
import org.koin.core.KoinComponent
import org.koin.core.inject

class CurrencyDetailsFragment: BaseFragment(), CurrencyDetailsFragmentView, KoinComponent {

    val currencyDetailsViewModel: CurrencyDetailsViewModel by inject()

    override fun whichLayout(): Int = R.layout.fragment_currency_detalis
}