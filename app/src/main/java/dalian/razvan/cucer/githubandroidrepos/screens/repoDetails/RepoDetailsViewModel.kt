package dalian.razvan.cucer.githubandroidrepos.screens.repoDetails

import dalian.razvan.cucer.githubandroidrepos.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.githubandroidrepos.core.repository.ReposRepository

class RepoDetailsViewModel(private val reposRepository: ReposRepository): BaseViewModel() {

    fun getDisplayName(): String? = reposRepository.getSelectedRepo()?.displayName
    fun getOwnerName(): String? = reposRepository.getSelectedRepo()?.createdBy
    fun getDescription(): String? = reposRepository.getSelectedRepo()?.description

    fun tryAPILoad(fragment: RepoDetailsFragmentView) {

    }
}