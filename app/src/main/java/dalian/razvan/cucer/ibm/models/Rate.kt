package dalian.razvan.cucer.ibm.models

import com.google.gson.annotations.SerializedName
import dalian.razvan.cucer.ibm.core.baseClasses.BaseModel
import dalian.razvan.cucer.ibm.core.network.Constants

data class Rate(@SerializedName(Constants.FROM) val from: String,
                @SerializedName(Constants.TO) val to: String,
                @SerializedName(Constants.RATE) val rate: Double): BaseModel() {

        override fun getObjectType(): Companion.Type = Companion.Type.RATE
    }
