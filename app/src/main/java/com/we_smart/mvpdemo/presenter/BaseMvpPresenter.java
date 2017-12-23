package com.we_smart.mvpdemo.presenter;

import com.we_smart.mvpdemo.view.IBaseView;

import java.lang.ref.WeakReference;

/**
 * Created by we_smart on 2017/12/23.
 * 泛型约束
 */

public class BaseMvpPresenter<V extends IBaseView> {

    protected WeakReference<V> mvpView;

    
    /*
    * 绑定视图对象
    * */
    public void attachMvpView(V view) {
        mvpView = new WeakReference<V>(view);
    }


    /*
    * 解绑视图
    * */
    public void detachView() {
        if (mvpView != null) {
            mvpView.clear();
            mvpView = null;
        }
    }
    
    
    /*
    * 获取视图对象
    * */

    public V getMvpView() {
        return mvpView.get();
    }

}
