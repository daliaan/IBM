package dalian.razvan.cucer.githubandroidrepos.core.repository

import dalian.razvan.cucer.githubandroidrepos.core.network.Result
import dalian.razvan.cucer.githubandroidrepos.models.Repo
import dalian.razvan.cucer.githubandroidrepos.core.network.API
import dalian.razvan.cucer.githubandroidrepos.core.network.model.ReposResponse
import dalian.razvan.cucer.githubandroidrepos.core.network.safeApiCall

class ReposRepositoryImpl(private val api: API): ReposRepository {

    private val repos = arrayListOf<Repo>()
    private var selectedRepo: Repo? = null
    private var currentPageNumber = 1

    override suspend fun loadRepos(): Result<ReposResponse?> = safeApiCall { api.getRepos(currentPageNumber) }

    override fun setRepos(list: ArrayList<Repo>) {
        repos.addAll(list)
        if (list.size > 0) currentPageNumber++
    }
    override fun getRepos(): ArrayList<Repo> = repos

    override fun setSelectedRepo(repo: Repo?) {
        selectedRepo = repo
    }
    override fun getSelectedRepo(): Repo? = selectedRepo
}