package dalian.razvan.cucer.ibm.customViews

import android.view.LayoutInflater
import android.view.ViewGroup
import dalian.razvan.cucer.ibm.R
import dalian.razvan.cucer.ibm.core.baseClasses.BaseRecyclerViewAdapter

class ReposAdapter: BaseRecyclerViewAdapter<Repo, ReposViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder
            = ReposViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.repo_cell, parent, false))
}