package com.shenzhe.lib_cache.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.maniu.lib_cache.dao.UserDao;
import com.maniu.lib_cache.datebase.CacheDataBase;
import com.maniu.lib_cache.model.User;

/**
 * 登录窗体所对应的ViewModel
 * 处理数据 1.保存到数据库的操作  2.从服务器获取数据
 */
public class LoginActivityViewModel extends ViewModel {
    private MutableLiveData<User> user;

    public MutableLiveData<User> getUser(){
        if(user ==null){
            user = new MutableLiveData<>();
            user.setValue(new User("lisan","123456",0,0));
        }
        return user;
    }

    public void loginRequest(){
        //假设在这里 请求了服务器  得到了结果
        User userBean = new User(user.getValue().getAccount(),
                user.getValue().getPassWord(),21,1);
        //保存到数据库
        //1.获取到数据库的操作引用
        CacheDataBase dataBase = CacheDataBase.getDataBase();
        //2.得到你要操作的表所对应的dao类
        UserDao userDao = dataBase.userDao();
        userDao.insertAll(userBean);
        //更新数据源
        user.setValue(userBean);
    }
}
