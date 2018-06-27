package skullper.world.selector.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import skullper.world.selector.BuildConfig
import skullper.world.selector.utils.AppPreferences
import java.util.concurrent.TimeUnit

/*
 * Created by pugman on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

/**
 * Class provides access to do requests.
 * Use [api] value to send one of the requests described in [Api] class.
 * In this representation you're not allowed to change end point on the fly
 */
object RestClient {

    private const val END_POINT = "http://backend1.lordsandknights.com/XYRALITY/WebObjects/"
    private const val TIMEOUT = 20L

    val api: Api = provideRetrofit().create(Api::class.java)

    private val authInterceptor: Interceptor
        get() = Interceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                    .header("accept", "application/json")
                    .method(original.method(), original.body())
                    .build()
            chain.proceed(request)
        }

    private val loggingInterceptor: HttpLoggingInterceptor
        get() {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return interceptor
        }

    private fun provideRetrofit(): Retrofit {
        val builder = OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(authInterceptor)
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor)
        }
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(END_POINT)
                .client(builder.build())
                .build()
    }

}