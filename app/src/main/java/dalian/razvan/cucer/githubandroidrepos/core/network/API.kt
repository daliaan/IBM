package dalian.razvan.cucer.githubandroidrepos.core.network

import dalian.razvan.cucer.githubandroidrepos.core.network.model.RepoDetailsReponse
import dalian.razvan.cucer.githubandroidrepos.core.network.model.ReposResponse
import retrofit2.Response
import retrofit2.http.*

interface API {

    @GET(Endpoints.SEARCH_TOPICS)
    suspend fun getRepos(@Query("page") pageNumber: Int): Response<ReposResponse>
    @GET(Endpoints.REPO_DETAILS)
    suspend fun getRepoDetails(@Path("owner") owner: String, @Path("repo_name") repoName: String): Response<RepoDetailsReponse>
}