package com.example.myapplicationlv1.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplicationlv1.fragments.PersonalInfoFragment;
import com.example.myapplicationlv1.fragments.StudentInfoFragment;
import com.example.myapplicationlv1.fragments.SummaryFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                 return new PersonalInfoFragment();

            case 1:
                return new StudentInfoFragment();

            case 2:
                return new SummaryFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
