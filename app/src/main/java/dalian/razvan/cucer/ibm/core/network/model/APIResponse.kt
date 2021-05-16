package dalian.razvan.cucer.ibm.core.network.model

import dalian.razvan.cucer.ibm.core.baseClasses.BaseModel
import dalian.razvan.cucer.ibm.models.Transaction

data class APIResponse<T: BaseModel>(val results: ArrayList<T>)