package dalian.razvan.cucer.ibm.core.baseClasses

abstract class BaseModel {

    companion object{
        enum class Type{
            RATE,
            TRANSACTION,
            NOT_SET
        }
    }

    var isSelected = false
    open fun getObjectType() = Type.NOT_SET
}