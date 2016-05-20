package divyanshu.aclaglid.in.aclagliddemos.PendingIntentExample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 02/05/16.
 */
public class MyBroadcatReceiver  extends BroadcastReceiver{
    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {

        mp = MediaPlayer.create(context, R.raw.rail);
        mp.start();
        Toast.makeText(context,"Alarm......",Toast.LENGTH_SHORT).show();

    }
}
