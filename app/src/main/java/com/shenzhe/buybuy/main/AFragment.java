package com.shenzhe.buybuy.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shenzhe.buybuy.R;
import com.shenzhe.buybuy.databinding.FragmentABinding;
import com.shenzhe.lib_cache.adapter.StoryAdapter;
import com.shenzhe.lib_cache.view_model.AFragmentViewModel;
import com.shenzhe.lib_common.base.BaseFragment;

public class AFragment extends BaseFragment {

    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        FragmentABinding fragmentABinding = DataBindingUtil.inflate(
                inflater,getLayoutRes(),container,false);
        AFragmentViewModel aFragmentViewModel = new AFragmentViewModel();
        RecyclerView recycler = fragmentABinding.recycler;
        recycler.setLayoutManager(new LinearLayoutManager(recycler.getContext(),
                LinearLayoutManager.VERTICAL, false));

        StoryAdapter adapter = new StoryAdapter(aFragmentViewModel.getStoriesLiveData().getValue());
        recycler.setAdapter(adapter);
        return fragmentABinding.getRoot();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initView() {

    }
}
