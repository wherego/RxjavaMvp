package com.mvp.ztt.rxjavamvp.model;

import com.mvp.ztt.rxjavamvp.model.bean.Repo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public class Api {
    private static final int DEFAULT_TIMEOUT = 15;
    private static volatile Api INSTANCE = null;
    private final ApiService service;
    private static final String BASE_URL = "https://api.github.com/";

    private Api() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build();
        service = retrofit.create(ApiService.class);
    }

    public static Api getInstance() {
        Api inst = INSTANCE;
        if (inst == null) {
            synchronized (Api.class) {
                inst = INSTANCE;
                if (inst == null) {
                    inst = new Api();
                    INSTANCE = inst;
                }
            }
        }
        return inst;
    }

    public Observable<List<Repo>> listRepos(String userName) {
        return service.listRepos(userName);
    }

}
