package dalian.razvan.cucer.ibm.screens.currencyDetails

import androidx.fragment.app.viewModels
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragment

class CurrencyDetailsFragment: BaseFragment(), CurrencyDetailsFragmentView {

    val currencyDetailsViewModel: CurrencyDetailsViewModel by viewModels()

    override fun whichLayout(): Int = R.layout.fragment_currency_detalis
}