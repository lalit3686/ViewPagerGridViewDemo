package com.example.viewpagerdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class MainActivity extends FragmentActivity {

	static final int ITEMS = 2;
	ViewPager mViewPager;
	static ArrayList<String> CHESSES = new ArrayList<String>();
	MyAdapter myAdapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        CHESSES.add("Chesse0");
        CHESSES.add("Chesse1");
        CHESSES.add("Chesse2");
        CHESSES.add("Chesse3");
        CHESSES.add("Chesse4");
        CHESSES.add("Chesse5");
        
        myAdapter = new MyAdapter(getSupportFragmentManager());
        
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(myAdapter);
    }
    
    static class MyAdapter extends FragmentStatePagerAdapter
    {
		public MyAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Log.d(getClass().getSimpleName(), position+"");
			return ArrayListFragment.newInstance(position);
		}

		@Override
		public int getCount() {
			return ITEMS;
		}
		
		@Override
		public int getItemPosition(Object object) {
			return POSITION_NONE;
		}
    }
}
