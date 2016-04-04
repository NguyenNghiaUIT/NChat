package com.nghianv.nghiachat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;

import com.nghianv.nghiachat.fragment.FriendFragment;
import com.nghianv.nghiachat.fragment.ProfileFragment;
import com.nghianv.nghiachat.fragment.TimeLimeFragment;

/**
 * Created by NguyenNghia on 4/3/2016.
 */
public class ChatViewPagerAdapter extends FragmentPagerAdapter {

    public ChatViewPagerAdapter(FragmentManager fm) {
        super(fm);
        Log.i("Nghia", "Voo");
    }
    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0:
               return new TimeLimeFragment();
           case 1:
               return new FriendFragment();
           case 2:
               return new ProfileFragment();
       }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return "Page " + position;
//    }
}
