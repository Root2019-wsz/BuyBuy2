package com.shenzhe.lib_cache.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
//import androidx.databinding.library.baseAdapters.BR;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_user")
public class User extends BaseObservable {
    private String account;

    private String passWord;

    private Integer age;

    @PrimaryKey
    private Integer u_id;

    public User(String account, String passWord, Integer age, Integer u_id) {
        this.account = account;
        this.passWord = passWord;
        this.age = age;
        this.u_id = u_id;
    }

    @Bindable
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
//        notifyPropertyChanged(BR.account);
    }

    @Bindable
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
//        notifyPropertyChanged(BR.passWord);
    }

    @Bindable
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
//        notifyPropertyChanged(BR.age);
    }

    @Bindable
    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
//        notifyPropertyChanged(BR.u_id);
    }
}
