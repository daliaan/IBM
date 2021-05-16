package dalian.razvan.cucer.ibm.customViews

import android.view.View
import dalian.razvan.cucer.ibm.core.baseClasses.BaseRecyclerViewHolder
import dalian.razvan.cucer.ibm.core.baseClasses.RecyclerViewItemClickListener
import kotlinx.android.synthetic.main.repo_cell.view.*

class ReposViewHolder(itemView: View): BaseRecyclerViewHolder<Repo>(itemView) {

    override fun bind(item: Repo, onItemClick: RecyclerViewItemClickListener<Repo>) {
        itemView.title.text = item.name
        itemView.setOnClickListener { onItemClick.onItemClick(item) }
    }
}
