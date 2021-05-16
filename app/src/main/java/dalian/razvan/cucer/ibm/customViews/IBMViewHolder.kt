package dalian.razvan.cucer.ibm.customViews

import android.view.View
import dalian.razvan.cucer.ibm.core.baseClasses.BaseModel
import dalian.razvan.cucer.ibm.core.baseClasses.BaseRecyclerViewHolder
import dalian.razvan.cucer.ibm.core.baseClasses.RecyclerViewItemClickListener
import dalian.razvan.cucer.ibm.models.Rate
import dalian.razvan.cucer.ibm.models.Transaction
import kotlinx.android.synthetic.main.rate_cell.view.*
import kotlinx.android.synthetic.main.transaction_cell.view.*

class IBMViewHolder<T: BaseModel>(itemView: View): BaseRecyclerViewHolder<T>(itemView) {

    override fun bind(item: T, onItemClick: RecyclerViewItemClickListener<T>) {
        when(item.getObjectType()) {
            BaseModel.Companion.Type.RATE -> {
                val rate = (item as Rate)

                itemView.rate_name.text = rate.from

                itemView.setOnClickListener { onItemClick.onItemClick(item) }
            }
            BaseModel.Companion.Type.TRANSACTION -> {
                val transaction = (item as Transaction)

                itemView.transaction_name.text = transaction.sku

                itemView.setOnClickListener { onItemClick.onItemClick(item) }
            }
            BaseModel.Companion.Type.NOT_SET -> {

            }
        }
    }
}
