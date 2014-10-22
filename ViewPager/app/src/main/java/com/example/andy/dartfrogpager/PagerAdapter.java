package com.example.andy.dartfrogpager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;

/**
 * Created by Andy on 22-Oct-14.
 */
public class PagerAdapter extends FragmentPagerAdapter{

    String[] mFrogScientificNames;
    String[] mFrogGenera;
    String[] mFrogDescriptions;


    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);

        mFrogScientificNames = context.getResources().getStringArray(R.array.frog_scientific_names);
        mFrogGenera = context.getResources().getStringArray(R.array.frog_genera);
        mFrogDescriptions = context.getResources().getStringArray(R.array.frog_descriptions);
    }

    @Override
    public Fragment getItem(int i) {

        Bundle args = new Bundle();
        args.putString(FrogFragment.FROG_SCIENTIFIC_NAME, mFrogScientificNames[i]);
        args.putString(FrogFragment.FROG_DESCRIPTION, mFrogDescriptions[i]);
        args.putInt(FrogFragment.FROG_IMAGE, adaptFrogImage(i));

        FrogFragment frogFragment = new FrogFragment();
        frogFragment.setArguments(args);

        return frogFragment;
    }




    private int adaptFrogImage(int i) {
        int frogImageId = 0;
        switch (i) {
            case 0:
                frogImageId = R.drawable.frog1;
                break;
            case 1:
                frogImageId = R.drawable.frog2;
                break;
            case 2:
                frogImageId = R.drawable.frog3;
                break;
            case 3:
                frogImageId = R.drawable.frog4;
                break;
            case 4:
                frogImageId = R.drawable.frog5;
                break;
            case 5:
                frogImageId = R.drawable.frog6;
                break;
            case 6:
                frogImageId = R.drawable.frog7;
                break;
            case 7:
                frogImageId = R.drawable.frog8;
                break;
        }
        return frogImageId;
    }

    @Override
    public int getCount() {
        return mFrogScientificNames.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFrogGenera[position];
    }
}
