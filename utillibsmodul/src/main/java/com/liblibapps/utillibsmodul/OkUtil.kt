package com.liblibapps.utillibsmodul

import android.os.Bundle
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient

class OkUtil: AppCompatActivity() {
    private lateinit var okHttpClient: OkHttpClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        okHttpClient = OkHttpClient.Builder()
            .followSslRedirects(false)
            .followRedirects(false)
            .addNetworkInterceptor {
                it.proceed(
                    it.request().newBuilder()
                        .header("User-Agent", WebSettings.getDefaultUserAgent(this))
                        .build()
                )
            }.build()

    }

}