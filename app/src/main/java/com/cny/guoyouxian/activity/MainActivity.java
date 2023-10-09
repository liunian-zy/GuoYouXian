package com.cny.guoyouxian.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.cny.guoyouxian.R;
import com.cny.guoyouxian.fragment.CartFragment;
import com.cny.guoyouxian.fragment.CategoryFragment;
import com.cny.guoyouxian.fragment.HomeFragment;
import com.cny.guoyouxian.fragment.MineFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView iv_home, iv_category, iv_cart, iv_mine;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_home = findViewById(R.id.home);
        iv_category = findViewById(R.id.category);
        iv_cart = findViewById(R.id.cart);
        iv_mine = findViewById(R.id.mine);

        frameLayout = findViewById(R.id.frame_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        HomeFragment homeFragment = new HomeFragment();
        fragmentTransaction.add(R.id.frame_main, homeFragment);
        fragmentTransaction.commit();

        iv_home.setOnClickListener(this);
        iv_category.setOnClickListener(this);
        iv_cart.setOnClickListener(this);
        iv_mine.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        int id = view.getId();
        if (id == R.id.home) {
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.replace(R.id.frame_main, homeFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.category) {
            CategoryFragment categoryFragment = new CategoryFragment();
            fragmentTransaction.replace(R.id.frame_main, categoryFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.cart) {
            CartFragment cartFragment = new CartFragment();
            fragmentTransaction.replace(R.id.frame_main, cartFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.mine) {
            MineFragment mineFragment = new MineFragment();
            fragmentTransaction.replace(R.id.frame_main, mineFragment);
            fragmentTransaction.commit();
        }
    }
}