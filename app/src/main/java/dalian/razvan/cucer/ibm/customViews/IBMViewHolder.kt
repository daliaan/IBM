package dalian.razvan.cucer.ibm.customViews

import android.view.View
import dalian.razvan.cucer.ibm.core.baseClasses.BaseModel
import dalian.razvan.cucer.ibm.core.baseClasses.BaseRecyclerViewHolder
import dalian.razvan.cucer.ibm.core.baseClasses.RecyclerViewItemClickListener
import dalian.razvan.cucer.ibm.models.Rate
import dalian.razvan.cucer.ibm.models.Transaction

class IBMViewHolder(itemView: View): BaseRecyclerViewHolder<BaseModel>(itemView) {

    override fun bind(item: BaseModel, onItemClick: RecyclerViewItemClickListener<BaseModel>) {
        when(item.getObjectType()) {
            BaseModel.Companion.Type.RATE -> {
                var rate = (item as Rate)


                itemView.setOnClickListener { onItemClick.onItemClick(item) }
            }
            BaseModel.Companion.Type.TRANSACTION -> {
                var transaction = (item as Transaction)


                itemView.setOnClickListener { onItemClick.onItemClick(item) }
            }
            BaseModel.Companion.Type.NOT_SET -> {

            }
        }
    }
}
