package divyanshu.aclaglid.in.aclagliddemos.SharedPreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.TextView;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 11/05/16.
 */
public class ShowActivity  extends Activity{


    EditText tv_userName;
    EditText tv_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show);

//        tv_userName = (EditText)findViewById(R.id.tv_userName);
//        tv_password = (EditText)findViewById(R.id.tv_password);
//        SharedPreferences prefs = getSharedPreferences("Acadgild", MODE_PRIVATE);
//        String userName = prefs.getString("username", null);
//        if (userName != null) {
//            String name = prefs.getString("username", "No name defined");//"No name defined" is the default value.
//            String  password = prefs.getString("password", "No PAssword"); //0 is the default value.
//
//            tv_userName.setText(name);
//            tv_password.setText(password);
//        }


        //############################################################

        TextView tv_checkbox_preference1 = (TextView)findViewById(R.id.tv_checkbox_preference1);
        TextView tv_checkbox_preference2 = (TextView)findViewById(R.id.tv_checkbox_preference2);
        TextView tv_edittext_preference1 = (TextView)findViewById(R.id.tv_edittext_preference1);
        TextView tv_list_preference1 = (TextView)findViewById(R.id.tv_list_preference1);
        TextView tv_ringtone_preference = (TextView)findViewById(R.id.tv_ringtone_preference);
        TextView tv_edittext_preference2 = (TextView)findViewById(R.id.tv_edittext_preference2);


        //FETCHING THE VALUES FROM SHARED PREFRENCES
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        boolean cb1 = sp.getBoolean("cbp_checkbox_preference1",false);
        boolean cb2 = sp.getBoolean("cbp_checkbox_preference2",false);

        String edit1 = sp.getString("etp_edittext_preference1_title","NO TITLE DATA");
        String list = sp.getString("lp_list_preferences","NOT SELECTED");
        String ringtone = sp.getString("rtp_ringtone_preference","NOT SELECTED");
        String edit2 = sp.getString("etp_edittext_preference2","NOT SELECTED");


        //SETTING MY VALUES IN THE VIEW
        tv_checkbox_preference1.setText("CHECK BOX Prefrence1:    "+Boolean.toString(cb1));
        tv_checkbox_preference2.setText("CHECK BOX Prefrence2:    "+Boolean.toString(cb2));
        tv_edittext_preference1.setText("EDIT TEXT PREFRENCE:   "+edit1);
        tv_list_preference1.setText("LIST PREFERENCE:    "+list);
        tv_ringtone_preference.setText("Ringtone preferences:   "+ringtone);
        tv_edittext_preference2.setText("Edit text Preferences 2:     "+edit2);

    }
}
