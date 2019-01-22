package com.bwei.homeworka.presenter;

import com.bwei.homeworka.R;
import com.bwei.homeworka.bean.Result;
import com.bwei.homeworka.core.DataCall;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zxk
 * on 2019/1/22 11:52
 * QQ:666666
 * Describe:
 */
public abstract class BasePresenter {
    private DataCall dataCall;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    public void unbind() {
        dataCall = null;
    }

    protected abstract Observable observable(Object... args);

    public void request(Object... args) {
        observable(args)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        dataCall.loadSuccess(result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        dataCall.loadError(throwable);
                    }
                });
    }
}
