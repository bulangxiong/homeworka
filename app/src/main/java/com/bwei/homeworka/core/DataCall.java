package com.bwei.homeworka.core;

import com.bwei.homeworka.bean.Result;

/**
 * Created by zxk
 * on 2019/1/22 9:47
 * QQ:666666
 * Describe:
 */
public interface DataCall<T>  {
    void loadSuccess(Result data);
    void loadError(Throwable throwable);
}
