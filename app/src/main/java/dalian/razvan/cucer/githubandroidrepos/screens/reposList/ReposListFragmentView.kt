package dalian.razvan.cucer.githubandroidrepos.screens.reposList

import dalian.razvan.cucer.githubandroidrepos.core.baseClasses.BaseFragmentView
import dalian.razvan.cucer.githubandroidrepos.models.Repo

interface ReposListFragmentView: BaseFragmentView {
    fun goToDetails()
    fun setList(list: ArrayList<Repo>)
}
