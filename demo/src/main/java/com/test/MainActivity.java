package com.test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.ms.tab.SmartTabLayout;
import com.ms.tab.fragment.FragmentPagerItemAdapter;
import com.ms.tab.fragment.FragmentPagerItems;
import com.ms.tab.util.Bundler;

public class MainActivity extends FragmentActivity {

    private String[] mTitles = new String[]{"旅游", "美食", "职场", "生活"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SmartTabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager = findViewById(R.id.view_pager);

        FragmentPagerItems.Creator creator = FragmentPagerItems.with(this);
        for (String mTitle : mTitles) {
            creator.add(mTitle, NewsTabFragment.class, new Bundler().putString("type", "1").get());
        }
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), creator.create());
        viewPager.setAdapter(adapter);
        tabLayout.setViewPager(viewPager);
    }
}
