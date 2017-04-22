package elementrdtesttask.com.elementrdtesttask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Andrey on 18.04.2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            default:
                return new FragmentOne();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

}
