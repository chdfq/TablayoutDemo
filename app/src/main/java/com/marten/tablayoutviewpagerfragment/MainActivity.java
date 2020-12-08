package com.marten.tablayoutviewpagerfragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTl1;
    private ViewPager mVp1;

    private ArrayList<Fragment> fragments;
    private ArrayList<String> strings;
    private FragmentManager fragmentManager;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTl1 = findViewById(R.id.tl_1);
        mVp1 = findViewById(R.id.vp_1);
        mTl1.setTabMode(TabLayout.MODE_SCROLLABLE);

        strings = new ArrayList<>();
        strings.add("直播");
        strings.add("推荐");
        strings.add("热门");
        strings.add("追番");

        fragments = new ArrayList<>();
        fragments.add(new Fragment_1());
        fragments.add(new Fragment_2());
        fragments.add(new Fragment_3());
        fragments.add(new Fragment_4());

        fragmentManager = getSupportFragmentManager();
        myAdapter = new MyAdapter(fragmentManager, strings, fragments);
        fragmentManager.beginTransaction().commitAllowingStateLoss();
        mVp1.setAdapter(myAdapter);

        mTl1.setupWithViewPager(mVp1);
    }
}