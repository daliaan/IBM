package dalian.razvan.cucer.githubandroidrepos.core.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitFactory {

    fun create(context: Context): API {
        val okHttpClient = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val headersInterceptor = Interceptor { chain ->
            chain.proceed(chain.request().newBuilder().addHeader("Accept", getCorrectHeader(chain)).build())
        }

        okHttpClient.addInterceptor(loggingInterceptor)
        okHttpClient.addInterceptor(headersInterceptor)
        okHttpClient.readTimeout(25, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(25, TimeUnit.SECONDS)

        return Retrofit.Builder()
                .baseUrl(Endpoints.BASE_URL)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(API::class.java)
    }

    private fun getCorrectHeader(chain: Interceptor.Chain): String {
        if (chain.request().url.toUrl().toString().contains("https://api.github.com/search"))
            return "application/vnd.github.mercy-preview+json"
        return "application/vnd.github.v3+json"
    }
}