package dalian.razvan.cucer.ibm.customViews

import android.view.LayoutInflater
import android.view.ViewGroup
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseModel
import dalian.razvan.cucer.ibm.core.baseClasses.BaseRecyclerViewAdapter

class IBMAdapter: BaseRecyclerViewAdapter<BaseModel, IBMViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IBMViewHolder
            = IBMViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ibm_list_cell, parent, false))
}