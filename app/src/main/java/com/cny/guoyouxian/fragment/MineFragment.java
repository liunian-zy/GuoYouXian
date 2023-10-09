package com.cny.guoyouxian.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.cny.guoyouxian.R;
import com.cny.guoyouxian.activity.DaiShouHuoActivity;
import com.cny.guoyouxian.activity.HelpActivity;
import com.cny.guoyouxian.activity.HuanHuoActivity;
import com.cny.guoyouxian.activity.LoginActivity;
import com.cny.guoyouxian.activity.TuiHuoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 我的
 */
public class MineFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        TextView login = view.findViewById(R.id.tv_login);
        ListView listView = view.findViewById(R.id.lv_mine);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 跳转到登录页面
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        String[] titles = {"待收货", "换货", "退货", "帮助中心"};
        int[] images = {R.drawable.daishouhuo, R.drawable.huanhuo, R.drawable.tuihuo, R.drawable.gengduo};
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("title", titles[i]);
            map.put("image", images[i]);
            data.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), data, R.layout.mylist_items, new String[]{"title", "image"}, new int[]{R.id.tv_my_list_item, R.id.iv_my_list_item});
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener((adapterView, view1, i, l) -> {
            switch (i) {
                case 0:
                    // 待收货
                    Intent intent = new Intent(getActivity(), DaiShouHuoActivity.class);
                    startActivity(intent);
                    break;
                case 1:
                    // 换货
                    Intent intent1 = new Intent(getActivity(), HuanHuoActivity.class);
                    startActivity(intent1);
                    break;
                case 2:
                    // 退货
                    Intent intent2 = new Intent(getActivity(), TuiHuoActivity.class);
                    startActivity(intent2);
                    break;
                case 3:
                    // 帮助中心
                    Intent intent3 = new Intent(getActivity(), HelpActivity.class);
                    startActivity(intent3);
                    break;
            }
        });

        return view;
    }
}