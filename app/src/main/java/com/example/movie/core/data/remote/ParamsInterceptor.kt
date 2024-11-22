package com.example.movie.core.data.remote

import com.example.movie.BuildConfig
import com.example.movie.core.util.Contants
import okhttp3.Interceptor
import okhttp3.Response

class ParamsInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter(Contants.LANGUAGE_PARAM,Contants.LANGUAGE_VALUE)
            .addQueryParameter(Contants.API_KEY_PARAM, BuildConfig.API_KEY)
            .build()

        val newRequest=request.newBuilder().url(url).build()

        return chain.proceed(newRequest)
    }
}