package pl.polsl.aeiimap.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import pl.polsl.aeiimap.fragments.FirstFloorFragment;
import pl.polsl.aeiimap.fragments.GroundFloorFragment;
import pl.polsl.aeiimap.fragments.SecondFloorFragment;

/**
 * Created by abienioszek on 21.09.2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    public static final int GROUND_FLOOR = 2;
    public static final int FIRST_FLOOR = 1;
    public static final int SECOND_FLOOR = 0;
    public static final int PAGER_COUNTER = 3;

    private Fragment currentFragment;


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case FIRST_FLOOR:
                currentFragment =  new FirstFloorFragment();
                break;
            case SECOND_FLOOR:
                currentFragment =  new SecondFloorFragment();
                break;
            default:
                currentFragment =  new GroundFloorFragment();
                break;
        }
        return currentFragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNTER;
    }
}

