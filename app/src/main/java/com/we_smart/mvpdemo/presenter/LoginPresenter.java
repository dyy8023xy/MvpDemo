package com.we_smart.mvpdemo.presenter;

import android.text.TextUtils;

import com.we_smart.mvpdemo.model.LoginCallBack;
import com.we_smart.mvpdemo.model.LoginModel;
import com.we_smart.mvpdemo.model.User;
import com.we_smart.mvpdemo.view.ILoginView;

/**
 * Created by we_smart on 2017/12/23.
 */

public class LoginPresenter extends BaseMvpPresenter<ILoginView> {

    private LoginModel mLoginModel;

    public LoginPresenter() {
        mLoginModel = new LoginModel();
    }

    public void startLogin(String account, String password) {
        if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
            getMvpView().onFail();
        } else {
            getMvpView().onStartLoading();
            mLoginModel.startLogin(account, password, new LoginCallBack() {
                @Override
                public void onFail(String errorCode, String errorText) {
                    getMvpView().onFail();
                }

                @Override
                public void onSuccess(User user) {
                    getMvpView().onSuccess(user);
                }
            });
        }
    }
    
    
}
