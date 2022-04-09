package com.shenzhe.lib_cache.model;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

/**
 * 测试数据
 */
public class Story extends BaseObservable {

    private String title;
    private Integer image;

    public Story(String title, Integer image) {
        this.title = title;
        this.image = image;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        //如果要做双向绑定
    }

    @Bindable
    public Integer getImage() {
        return image;
    }


    public void setImage(Integer image) {
        this.image = image;
    }

    @BindingAdapter({"android:src"})
    public static void setImageResource(ImageView imageView, int resource ) {
        imageView.setImageResource( resource );
    }
}