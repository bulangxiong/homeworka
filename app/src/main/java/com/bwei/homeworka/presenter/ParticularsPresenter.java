package com.bwei.homeworka.presenter;

import com.bwei.homeworka.MainActivity;
import com.bwei.homeworka.R;
import com.bwei.homeworka.core.DataCall;
import com.bwei.homeworka.core.IReuqest;
import com.bwei.homeworka.http.HttpUtils;

import io.reactivex.Observable;

/**
 * Created by zxk
 * on 2019/1/22 11:57
 * QQ:666666
 * Describe:
 */
public class ParticularsPresenter  extends BasePresenter{
    public ParticularsPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        IReuqest iReuqest = HttpUtils.getHttpUtils().create(IReuqest.class);

        return iReuqest.getProductDetail((int)args[0]);
    }
}
