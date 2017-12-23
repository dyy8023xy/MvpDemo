package com.we_smart.mvpdemo.model;

/**
 * Created by we_smart on 2017/12/23.
 */

public class LoginModel {

    /*
    * 模拟网络请求
    * */
    public void startLogin(final String account, final String password, final LoginCallBack loginCallBack) {
        if (loginCallBack == null) throw new NullPointerException("LoginCallBack can not Null");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    User user = new User();
                    user.setAccount(account);
                    user.setPassword(password);
                    loginCallBack.onSuccess(user);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    loginCallBack.onFail("1", e.getMessage().toString());
                }
            }
        }).start();
        
    }
}
