package dalian.razvan.cucer.ibm.customViews

import android.annotation.SuppressLint
import android.view.View
import dalian.razvan.cucer.ibm.core.baseClasses.BaseModel
import dalian.razvan.cucer.ibm.core.baseClasses.BaseRecyclerViewHolder
import dalian.razvan.cucer.ibm.core.baseClasses.RecyclerViewItemClickListener
import dalian.razvan.cucer.ibm.models.Currency
import dalian.razvan.cucer.ibm.models.Rate
import dalian.razvan.cucer.ibm.models.SKUValue
import dalian.razvan.cucer.ibm.models.Transaction
import kotlinx.android.synthetic.main.currency_cell.view.*
import kotlinx.android.synthetic.main.rate_cell.view.*
import kotlinx.android.synthetic.main.sku_value_cell.view.*
import kotlinx.android.synthetic.main.transaction_cell.view.*

class IBMViewHolder<T: BaseModel>(itemView: View): BaseRecyclerViewHolder<T>(itemView) {

    @SuppressLint("SetTextI18n")
    override fun bind(item: T, onItemClick: RecyclerViewItemClickListener<T>) {
        when(item.getObjectType()) {
            BaseModel.Companion.Type.RATE -> {
                val rate = (item as Rate)

                itemView.rate_name.text = rate.to
                itemView.rate_value.text = rate.rate.toString()
            }
            BaseModel.Companion.Type.TRANSACTION -> {
                val transaction = (item as Transaction)

                itemView.transaction_currency_name.text = transaction.currency
                itemView.transaction_value.text = transaction.amount.toString()
            }
            BaseModel.Companion.Type.SKU_VALUE -> {
                val skuValue = (item as SKUValue)

                itemView.sku_value_name.text = skuValue.sku
                itemView.sku_value_amount.text = skuValue.getTotalAmount() + '\n' + skuValue.getSelectedCurrency()
            }
            BaseModel.Companion.Type.CURRENCY -> {
                val currency = (item as Currency)

                itemView.currency_name.text = currency.name
            }
            BaseModel.Companion.Type.NOT_SET -> {

            }
        }

        itemView.setOnClickListener { onItemClick.onItemClick(item) }
    }
}
