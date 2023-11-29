package com.example.glistenglowgifts.fragments.vewPager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.glistenglowgifts.R;

public class CustomViewPagerAdapter extends FragmentStateAdapter {
    public CustomViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /**
     * This method is responsible for creating and returning a Fragment based on the given position.
     * It is used by the adapter to determine which Fragment to display at a specific position within the ViewPager2.
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return CreditsFragment.newInstance("agusyornet.com", R.drawable.a_and_y);
            case 1: return CreditsFragment.newInstance("thesprucecrafts.com", R.drawable.spruce);
            case 2: return CreditsFragment.newInstance("makeit-loveit.com", R.drawable.makeit);
            case 3: return CreditsFragment.newInstance("thenavagepatch.com", R.drawable.navage);
            case 4: return CreditsFragment.newInstance("luxe.digital", R.drawable.luxe);
            case 5: return CreditsFragment.newInstance("happinessishomemade.net", R.drawable.happiness);
            case 6: return CreditsFragment.newInstance("realsimple.com", R.drawable.real_simple);
            case 7: return CreditsFragment.newInstance("kiwico.com", R.drawable.kiwi);
            default: return CreditsFragment.newInstance( "404: Fragment not found", 1);
        }
    }

    /**
     *  This method is used to determine the total number of items (fragments) that the ViewPager2 will display.
     */
    @Override
    public int getItemCount() {
        return 7;
    }
}
