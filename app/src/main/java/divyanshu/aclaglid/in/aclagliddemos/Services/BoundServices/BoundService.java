package divyanshu.aclaglid.in.aclagliddemos.Services.BoundServices;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 03/06/16.
 */
public class BoundService extends Service {

    private final IBinder myBinder = new MyLocalBinder();
    private  Thread backgroundThread;
    private MediaPlayer player;
    private int NOTIFICATION_ID = 102;
    private String TAG = "bound";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                playMusic();
            }
        });
        backgroundThread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    private void playMusic(){
        if(player!=null){
            player.release();
        }
        player = MediaPlayer.create(this, R.raw.music_thunder);
        player.setLooping(true);
    }

    public void startPlay(){
        if(!player.isPlaying()){
            player.start();
        }
    }

    public void stopPlay(){
        if(player.isPlaying()){
            player.pause();
        }
    }

    public class MyLocalBinder extends Binder{
        BoundService getService(){
            return BoundService.this;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        player.release();
        player = null;

        Thread dummy = backgroundThread;
        backgroundThread = null;
        dummy.interrupt();

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        Toast.makeText(getApplicationContext(),"Cancelling Notification is Called",Toast.LENGTH_SHORT).show();
        notificationManager.cancel(NOTIFICATION_ID);
    }
}
