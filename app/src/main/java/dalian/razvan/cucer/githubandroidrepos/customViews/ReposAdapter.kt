package dalian.razvan.cucer.githubandroidrepos.customViews

import android.view.LayoutInflater
import android.view.ViewGroup
import dalian.razvan.cucer.githubandroidrepos.R
import dalian.razvan.cucer.githubandroidrepos.core.baseClasses.BaseRecyclerViewAdapter
import dalian.razvan.cucer.githubandroidrepos.models.Repo

class ReposAdapter: BaseRecyclerViewAdapter<Repo, ReposViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder
            = ReposViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.repo_cell, parent, false))
}