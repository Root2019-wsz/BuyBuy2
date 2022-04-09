package com.shenzhe.lib_cache.datebase;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.maniu.lib_cache.dao.UserDao;
import com.maniu.lib_cache.model.User;
import com.maniu.lib_common.util.AppGlobals;

@Database(entities = {User.class},version = 1)
public abstract class CacheDataBase extends RoomDatabase {
    private static final CacheDataBase database;
    static {
        //创建数据库
        database = Room.databaseBuilder(AppGlobals.getsApplication(),CacheDataBase.class,"db")
                //允许在主线程中执行查询
        .allowMainThreadQueries()
        .build();
    }

    public static CacheDataBase getDataBase(){
        return database;
    }

    public abstract UserDao userDao();
}
