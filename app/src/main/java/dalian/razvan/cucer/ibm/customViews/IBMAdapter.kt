package dalian.razvan.cucer.ibm.customViews

import android.view.LayoutInflater
import android.view.ViewGroup
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseModel
import dalian.razvan.cucer.ibm.core.baseClasses.BaseRecyclerViewAdapter
import dalian.razvan.cucer.ibm.models.Rate

class IBMAdapter<T: BaseModel>: BaseRecyclerViewAdapter<T, IBMViewHolder<T>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IBMViewHolder<T>
            = IBMViewHolder(LayoutInflater.from(parent.context).inflate(whichLayout(viewType), parent, false))

    override fun whichLayout(viewType: Int): Int = when(viewType) {
        0 -> {
            R.layout.rate_cell
        }
        1 -> {
            R.layout.transaction_cell
        }
        else -> {
            R.layout.ibm_list_cell
        }
    }
}