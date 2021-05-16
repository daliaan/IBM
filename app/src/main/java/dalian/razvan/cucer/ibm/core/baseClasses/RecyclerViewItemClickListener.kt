package dalian.razvan.cucer.ibm.core.baseClasses

interface RecyclerViewItemClickListener<T: BaseModel> {

    fun onItemClick(item: T)
}