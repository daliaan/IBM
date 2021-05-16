package dalian.razvan.cucer.ibm.screens.rates

import androidx.fragment.app.viewModels
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragment

class RatesFragment: BaseFragment(), RatesFragmentView {

    val ratesViewModel: RatesViewModel by viewModels()

    override fun whichLayout(): Int = R.layout.fragment_rates
}