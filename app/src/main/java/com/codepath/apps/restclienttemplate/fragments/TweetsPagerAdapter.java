package com.codepath.apps.restclienttemplate.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.codepath.apps.restclienttemplate.adapters.SmartFragmentStatePagerAdapter;

/**
 * Created by prernamanaktala on 10/5/17.
 */

public class TweetsPagerAdapter extends SmartFragmentStatePagerAdapter {


    private String[] tabTitles = new String[] {"Home","Mentions"};
    private Context mContext;

    public TweetsPagerAdapter(FragmentManager fragmentManager, Context context){
        super(fragmentManager);
        mContext = context;
    }
    @Override
    public int getCount(){
        return 2;
    }

    @Override
    public Fragment getItem(int position){
        if(position == 0){
            return new HomeTimelineFragment();
        }
        else if(position == 1){
            return new MentionsTimelineFragment();
        }
        else{
            return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabTitles[position];
    }
}
