package divyanshu.aclaglid.in.aclagliddemos.ActionBar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import divyanshu.aclaglid.in.aclagliddemos.ActionBar.ButtonsFragment;
import divyanshu.aclaglid.in.aclagliddemos.ActionBar.ColorsFragment;
import divyanshu.aclaglid.in.aclagliddemos.ActionBar.ImagesFragment;


public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Buttons fragment activity
			return new ButtonsFragment();
		case 1:
			// Colors fragment activity
			return new ButtonsFragment();
		case 2:
			// Images fragment activity
			return new ImagesFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}
