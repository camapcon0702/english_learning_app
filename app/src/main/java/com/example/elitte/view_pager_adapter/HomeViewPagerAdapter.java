package com.example.elitte.view_pager_adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.elitte.fragment.HomeExerciseFragment;
import com.example.elitte.fragment.LearningFragment;

public class HomeViewPagerAdapter extends FragmentStateAdapter {
    public HomeViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new LearningFragment();
            case 1:
                return new HomeExerciseFragment();
            default:
                return new LearningFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
