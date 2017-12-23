package com.we_smart.mvpdemo.model;

/**
 * Created by we_smart on 2017/12/23.
 */

public interface CallBack<T> {

    //成功
    void onSuccess(T t);

    void onFail(String errorCode, String errorText);
}
