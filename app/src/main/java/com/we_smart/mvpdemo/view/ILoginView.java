package com.we_smart.mvpdemo.view;

import com.we_smart.mvpdemo.model.User;

/**
 * Created by we_smart on 2017/12/23.
 */

public interface ILoginView extends IBaseView {

    void onSuccess(User user);

    void onFail();

    void onStartLoading();
}
