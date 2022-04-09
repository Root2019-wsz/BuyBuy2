package com.shenzhe.lib_cache.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.shenzhe.lib_cache.R;
import com.shenzhe.lib_cache.model.Story;

import java.util.ArrayList;


public class AFragmentViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Story>> storiesLiveData;


    public MutableLiveData<ArrayList<Story>> getStoriesLiveData() {
        if(storiesLiveData == null){
            storiesLiveData = new MutableLiveData<>();
            initData();
        }
        return storiesLiveData;
    }

    public void initData(){
        //采取临时数据
        ArrayList<Story> arrayList = new ArrayList<>();
        for(int x =0;x<10;x++){
            Story story = new Story("我是一个憨憨", R.mipmap.ic_chaoshi);
            arrayList.add(story);
        }
        storiesLiveData.setValue(arrayList);
    }
}
