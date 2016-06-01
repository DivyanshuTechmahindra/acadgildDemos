package divyanshu.aclaglid.in.aclagliddemos.BroadcasrReceivers;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 01/06/16.
 */
public class RegisterUnregister extends Activity {


    UserDefinedBroadcasrreceiver broadcasrreceiver = new UserDefinedBroadcasrreceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_unregister);
    }

    public void registerBroadcastReceiver(View view){

        this.registerReceiver(broadcasrreceiver,new IntentFilter("com.acadgild.own"));
        Toast.makeText(this,"Enabled broadcast receier",Toast.LENGTH_SHORT).show();
    }

    public void unregisterBroadcastReceiver(View view){

        this.unregisterReceiver(broadcasrreceiver);
        Toast.makeText(this,"Disable broadcast receier",Toast.LENGTH_SHORT).show();
    }

//    public void showNotification(View view){
//        Intent intent = new Intent();
//        intent.setAction("com.acadgild.own");
//        sendBroadcast(intent);
//    }

}
