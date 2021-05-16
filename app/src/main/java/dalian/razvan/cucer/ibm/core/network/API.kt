package dalian.razvan.cucer.ibm.core.network

import retrofit2.Response
import retrofit2.http.*

interface API {

    @GET(Endpoints.TRANSACTIONS)
    suspend fun getRepos(@Query("page") pageNumber: Int): Response<ReposResponse>
    @GET(Endpoints.RATES)
    suspend fun getRepoDetails(@Path("owner") owner: String, @Path("repo_name") repoName: String): Response<RepoDetailsReponse>
}