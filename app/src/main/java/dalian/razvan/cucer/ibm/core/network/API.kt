package dalian.razvan.cucer.ibm.core.network

import dalian.razvan.cucer.ibm.core.network.model.APIResponse
import dalian.razvan.cucer.ibm.models.Rate
import dalian.razvan.cucer.ibm.models.Transaction
import retrofit2.Response
import retrofit2.http.*

interface API {

    @GET(Endpoints.RATES)
    suspend fun getRates(): Response<APIResponse<Rate>>
    @GET(Endpoints.TRANSACTIONS)
    suspend fun getTransactions(): Response<APIResponse<Transaction>>
}