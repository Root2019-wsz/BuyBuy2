package com.shenzhe.buybuy.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.shenzhe.buybuy.R;
import com.shenzhe.buybuy.databinding.ActivityLoginBinding;
import com.shenzhe.buybuy.main.MainActivity;
import com.shenzhe.lib_cache.model.User;
import com.shenzhe.lib_cache.view_model.LoginActivityViewModel;
import com.shenzhe.lib_common.base.BaseActivity;

public class LoginActivity extends BaseActivity {
    LoginActivityViewModel loginActivityViewModel;
    ActivityLoginBinding activityLoginBinding;
    MutableLiveData<User> user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将xml进行绑定
        activityLoginBinding  =
                DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setLifecycleOwner(this);
        //创建Activity所对应的VIewmodel
        loginActivityViewModel = new LoginActivityViewModel();
        activityLoginBinding.setViewModel(loginActivityViewModel);
        user  = activityLoginBinding.getViewModel().getUser();
        user.observe(LoginActivity.this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                //做验证
                if(user!= null && user.getU_id()!=0){
                    //跳转到首页
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        });
    }

    public void updateData(View view) {
        //登录的请求
        loginActivityViewModel.loginRequest();
    }
}
