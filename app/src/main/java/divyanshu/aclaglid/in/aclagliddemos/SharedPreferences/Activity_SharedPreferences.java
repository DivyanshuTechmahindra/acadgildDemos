package divyanshu.aclaglid.in.aclagliddemos.SharedPreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 11/05/16.
 */
public class Activity_SharedPreferences extends Activity{

    Button btn_settings, btn_show,btn_saveValues;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedprefrences);


        btn_settings = (Button)findViewById(R.id.btn_settings);
        btn_show = (Button)findViewById(R.id.btn_show);



        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentSetting  = new Intent(Activity_SharedPreferences.this, SettingActivity.class);
                startActivity(intentSetting);
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent showIntent = new Intent(Activity_SharedPreferences.this,ShowActivity.class);
                startActivity(showIntent);
            }
        });

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);





        btn_saveValues = (Button)findViewById(R.id.btn_saveValues);
        btn_saveValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("Acadgild",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();


                editor.putString("username",username.getText().toString());
                editor.putString("password",password.getText().toString());

                editor.commit();
            }
        });


    }
}
