package dalian.razvan.cucer.githubandroidrepos.screens.reposList

import androidx.lifecycle.viewModelScope
import dalian.razvan.cucer.githubandroidrepos.core.network.Result
import dalian.razvan.cucer.githubandroidrepos.R
import dalian.razvan.cucer.githubandroidrepos.core.baseClasses.BaseViewModel
import dalian.razvan.cucer.githubandroidrepos.core.baseClasses.RecyclerViewItemClickListener
import dalian.razvan.cucer.githubandroidrepos.core.repository.ReposRepository
import dalian.razvan.cucer.githubandroidrepos.models.Repo
import kotlinx.coroutines.launch

class ReposListViewModel(private val repository: ReposRepository): BaseViewModel() {

    fun getReposItemClick(fragment: ReposListFragmentView): RecyclerViewItemClickListener<Repo>  = object: RecyclerViewItemClickListener<Repo> {
        override fun onItemClick(item: Repo) {
            repository.setSelectedRepo(item)
            fragment.goToDetails()
        }
    }

    fun load(fragment: ReposListFragmentView) {
        viewModelScope.launch {
            when(val response = repository.loadRepos()) {
                is Result.Success -> {
                    val reposResponse = response.value
                    reposResponse?.let {
                        if (it.totalCount > 0) {
                            if (it.repos.size == 0) {
                                fragment.showPopup(R.string.no_more_repos)
                            } else {
                                repository.setRepos(it.repos)
                                fragment.setList(it.repos)
                            }
                        } else {
                            fragment.showPopup(R.string.repos_not_loaded)
                        }
                    }
                }
                else -> {
                    fragment.showPopup(R.string.loading_repos_failed)
                }
            }
        }
    }
}