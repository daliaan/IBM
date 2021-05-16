package dalian.razvan.cucer.githubandroidrepos.core.baseClasses

interface RecyclerViewItemClickListener<T: BaseModel> {

    fun onItemClick(item: T)
}