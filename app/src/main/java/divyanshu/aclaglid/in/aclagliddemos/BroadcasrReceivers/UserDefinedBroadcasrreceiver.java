package divyanshu.aclaglid.in.aclagliddemos.BroadcasrReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by divyanshu on 01/06/16.
 */
public class UserDefinedBroadcasrreceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equalsIgnoreCase("com.acadgild.own")){
            StringBuilder msgStr = new StringBuilder("Current  Time :");
            Format foramatter = new SimpleDateFormat("hh:mm:ss a");
            msgStr.append(foramatter.format(new Date()));
            Toast.makeText(context,msgStr,Toast.LENGTH_SHORT).show();
        }
    }
}
