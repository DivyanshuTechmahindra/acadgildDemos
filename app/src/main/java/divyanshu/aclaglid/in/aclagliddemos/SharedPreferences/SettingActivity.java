package divyanshu.aclaglid.in.aclagliddemos.SharedPreferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 11/05/16.
 */
public class SettingActivity extends PreferenceActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
