package com.mvp.ztt.rxjavamvp.model;

import com.mvp.ztt.rxjavamvp.model.bean.Repo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public interface ApiService {
    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user);
}
