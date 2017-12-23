package com.we_smart.mvpdemo.ui;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Window;
import android.widget.EditText;

import com.we_smart.mvpdemo.R;
import com.we_smart.mvpdemo.model.User;
import com.we_smart.mvpdemo.presenter.LoginPresenter;
import com.we_smart.mvpdemo.view.ILoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<ILoginView, LoginPresenter> implements ILoginView {

    @BindView(R.id.account_input)
    EditText mAccountEditText;

    @BindView(R.id.password_input)
    EditText mPasswordEditText;
    private AlertDialog mAlertDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.login)
    void startLogin() {
        String account = mAccountEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        mvpPresenter.startLogin(account, password);
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void onSuccess(User user) {
        if (mAlertDialog != null) {
            mAlertDialog.dismiss();
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("account", user.getAccount());
        startActivity(intent);
    }

    @Override
    public void onFail() {
        if (mAlertDialog != null) {
            mAlertDialog.dismiss();
        }
        Snackbar.make(getWindow().getDecorView().findViewById(R.id.constraintLayout), "错误", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onStartLoading() {
        mAlertDialog = new AlertDialog.Builder(this).create();
        if (!mAlertDialog.isShowing()) mAlertDialog.show();
        Window window = mAlertDialog.getWindow();
        if (window != null) {
            window.setContentView(R.layout.login_network_custom_dialog_view);
            window.setBackgroundDrawable(new BitmapDrawable());
        }
    }
}
