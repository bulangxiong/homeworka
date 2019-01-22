package com.bwei.homeworka.http;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zxk
 * on 2019/1/22 9:38
 * QQ:666666
 * Describe:
 */
public class HttpUtils {
    private static HttpUtils httpUtils = new HttpUtils();
    private Retrofit retrofit;

    private HttpUtils() {
        init();
    }

    public static HttpUtils getHttpUtils() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }

    private void init() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        OkHttpClient build = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .client(build)
                .baseUrl("http://www.zhaoapi.cn/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }
}
