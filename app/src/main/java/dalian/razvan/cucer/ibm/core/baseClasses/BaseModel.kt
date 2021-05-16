package dalian.razvan.cucer.ibm.core.baseClasses

abstract class BaseModel {

    companion object{
        enum class Type(var viewType: Int){
            RATE(0),
            TRANSACTION(1),
            SKU_VALUE(2),
            CURRENCY(3),
            NOT_SET(-1)
        }
    }

    var isSelected = false
    open fun getObjectType() = Type.NOT_SET
}