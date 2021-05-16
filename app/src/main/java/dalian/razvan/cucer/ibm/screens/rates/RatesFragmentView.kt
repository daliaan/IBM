package dalian.razvan.cucer.ibm.screens.rates

import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragmentView
import dalian.razvan.cucer.ibm.models.Rate
import java.util.ArrayList

interface RatesFragmentView: BaseFragmentView {
    fun setList(rates: ArrayList<Rate>)
}