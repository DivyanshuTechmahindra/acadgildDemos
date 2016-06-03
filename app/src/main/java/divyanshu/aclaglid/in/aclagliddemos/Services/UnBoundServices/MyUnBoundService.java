package divyanshu.aclaglid.in.aclagliddemos.Services.UnBoundServices;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by divyanshu on 03/06/16.
 */
public class MyUnBoundService extends Service {

    Timer timer;

    TimerTask timerTask;
    final Handler handler = new Handler();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(),"On create called",Toast.LENGTH_SHORT).show();

        startTimer();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(),"On onStartCommand called",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"On onDestroy called",Toast.LENGTH_SHORT).show();
        stopTimerTask();
    }

    public void startTimer(){
        timer = new Timer();
        initializerTimerTask();

        timer.schedule(timerTask, 5000, 10000);
    }

    public void stopTimerTask(){
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }

    public void initializerTimerTask(){
        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:mm:yyyy HH:mm:ss a");
                        final  String strDate  = simpleDateFormat.format(calendar.getTime());


                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(getApplicationContext(),strDate,duration);
                        toast.show();
                    }
                });
            }
        };
    }

}
