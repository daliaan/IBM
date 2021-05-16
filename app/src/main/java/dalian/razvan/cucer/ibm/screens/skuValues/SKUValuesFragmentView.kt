package dalian.razvan.cucer.ibm.screens.skuValues

import dalian.razvan.cucer.ibm.core.baseClasses.BaseFragmentView
import dalian.razvan.cucer.ibm.models.SKUValue
import java.util.ArrayList

interface SKUValuesFragmentView: BaseFragmentView {
    fun setList(skuValues: ArrayList<SKUValue>)

}
