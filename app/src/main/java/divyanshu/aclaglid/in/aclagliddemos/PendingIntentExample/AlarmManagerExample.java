package divyanshu.aclaglid.in.aclagliddemos.PendingIntentExample;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 02/05/16.
 */
public class AlarmManagerExample  extends Activity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.alarm_manager_example);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlert();
            }
        });
    }

    public void startAlert(){
        EditText text = (EditText)findViewById(R.id.time);
        int i = Integer.parseInt(text.getText().toString());

        Intent intent = new Intent(this, MyBroadcatReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),23432443,intent,0);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(i*1000),pendingIntent);

        Toast.makeText(this,"Alarm set in "+i+" second",Toast.LENGTH_SHORT).show();
    }
}
