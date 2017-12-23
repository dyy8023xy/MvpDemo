package com.we_smart.mvpdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.we_smart.mvpdemo.presenter.BaseMvpPresenter;
import com.we_smart.mvpdemo.view.IBaseView;

/**
 * Created by we_smart on 2017/12/23.
 */

public abstract class BaseActivity<V extends IBaseView, P extends BaseMvpPresenter> extends AppCompatActivity {

    protected P mvpPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mvpPresenter == null) {
            mvpPresenter = createPresenter();
        }
        mvpPresenter.attachMvpView((V) this);
    }

    /*
    * 必须实现的方式Presenter。
    * */
    protected abstract P createPresenter();
    
    /*
    * 解除绑定
    * */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }

    /*
    * 外部获取Presenter
    * */
    public P getMvpPresenter() {
        return mvpPresenter;
    }
}
