package com.bwei.homeworka.core;

import com.bwei.homeworka.bean.Result;
import com.bwei.homeworka.bean.Shop;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zxk
 * on 2019/1/22 9:48
 * QQ:666666
 * Describe:
 */
public interface IReuqest {
    @GET("product/getProductDetail")
    Observable<Result> getProductDetail(@Query("pid") int pid);
}
