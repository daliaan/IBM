package dalian.razvan.cucer.ibm.models

import com.google.gson.annotations.SerializedName
import dalian.razvan.cucer.ibm.core.baseClasses.BaseModel
import dalian.razvan.cucer.ibm.core.network.Constants
import java.util.*

data class Transaction(@SerializedName(Constants.SKU) val sku: String,
                       @SerializedName(Constants.AMOUNT) val amount: Double,
                       @SerializedName(Constants.CURRENCY) val currency: String): BaseModel() {
    override fun getObjectType(): Companion.Type = Companion.Type.TRANSACTION
}
