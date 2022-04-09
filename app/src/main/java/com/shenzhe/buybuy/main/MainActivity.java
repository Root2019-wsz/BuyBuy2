package com.shenzhe.buybuy.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.shenzhe.buybuy.R;
import com.shenzhe.buybuy.databinding.ActivityMainBinding;
import com.shenzhe.lib_cache.view_model.MainActivityViewModel;
import com.shenzhe.lib_common.base.BaseActivity;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityMainBinding activityMainBinding;
    MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_main);
        //注册生命周期
        activityMainBinding.setLifecycleOwner(this);
        mainActivityViewModel = new MainActivityViewModel();
        initView();
    }

    private void initView() {
        //DrawerLayout和Toolbar关联起来
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, activityMainBinding.dl,
                activityMainBinding.include.toolbar,
                R.string.open, R.string.close);
        //初始化状态
        actionBarDrawerToggle.syncState();
        activityMainBinding.dl.addDrawerListener(actionBarDrawerToggle);
        //注册侧滑栏里面的点击事件
        activityMainBinding.navigationView.setNavigationItemSelectedListener(this);


        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.nav_fragment);
        final NavController navController = NavHostFragment.findNavController(fragment);
        onPrepareOptionsMenu(activityMainBinding.navBottom.getMenu());

        //给Button注册点击事件
        activityMainBinding.navBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Log.e("MN--------->",menuItem.getItemId()+"");
                navController.navigate(menuItem.getItemId());
                return !TextUtils.isEmpty(menuItem.getTitle());
            }
        });

        NavigationUI.setupWithNavController(activityMainBinding.navBottom,navController);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        String title = (String) menuItem.getTitle();
        Toast.makeText(this, "点击了----- " + title, Toast.LENGTH_SHORT).show();
        return false;
    }
}