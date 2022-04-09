package com.shenzhe.lib_common.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
    public View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutRes(),container,false);
        initView();
        return view;
    }

    //获取所有子类的xml资源文件
    protected abstract int getLayoutRes();

    //初始化控件
    protected abstract void initView();
}
