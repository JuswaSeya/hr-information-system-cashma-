package com.example.hello_world.bottombar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.hello_world.DashBoardFragment;
import com.example.hello_world.InfoFragment;

public class homeAdaptor extends FragmentStateAdapter {

    public homeAdaptor (@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DashBoardFragment();  // Home
            case 1:
                return new InfoFragment();  // Info
            default:
                return null;

        }

    }

    @Override
    public int getItemCount() {
        return 2; // number of tabs
    }
}
