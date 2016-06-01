package divyanshu.aclaglid.in.aclagliddemos.BroadcasrReceivers;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.support.v7.app.NotificationCompat.Builder;

import divyanshu.aclaglid.in.aclagliddemos.R;
import divyanshu.aclaglid.in.aclagliddemos.SplashScreen;

/**
 * Created by divyanshu on 01/06/16.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    private static final int NOTIFY_ME_ID = 101;
    @Override
    public void onReceive(Context context, Intent intent) {


        NotificationCompat.Builder mBuilder = (Builder) new Builder(
                context.getApplicationContext())
                .setSmallIcon(R.drawable.appicon6)
                .setContentTitle("ACADGILD EXAMPLE")
                .setContentText("This is the demo text");
        mBuilder.setAutoCancel(true);

        Intent resultIntent  = new Intent(context,SplashScreen.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context,0,resultIntent,0);
        mBuilder.setContentIntent(resultPendingIntent);


        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIFY_ME_ID,mBuilder.build());


    }
}
