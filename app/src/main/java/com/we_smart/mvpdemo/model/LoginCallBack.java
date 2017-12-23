package com.we_smart.mvpdemo.model;

/**
 * Created by we_smart on 2017/12/23.
 */

public interface LoginCallBack extends CallBack<User> {

    void onFail(String errorCode, String errorText);

    void onSuccess(User user);
}
