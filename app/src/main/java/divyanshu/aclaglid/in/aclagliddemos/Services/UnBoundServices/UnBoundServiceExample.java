package divyanshu.aclaglid.in.aclagliddemos.Services.UnBoundServices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 03/06/16.
 */
public class UnBoundServiceExample extends Activity implements View.OnClickListener {


    Button startServiceBTN, stopServiceBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unboundservices);


        startServiceBTN = (Button)findViewById(R.id.startService);
        stopServiceBTN = (Button)findViewById(R.id.stopService);

        startServiceBTN.setOnClickListener(this);
        stopServiceBTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.startService:
                Intent startServiceIntent = new Intent(UnBoundServiceExample.this,MyUnBoundService.class);
                startService(startServiceIntent);
                break;

            case R.id.stopService:
                Intent stopServiceIntent = new Intent(UnBoundServiceExample.this,MyUnBoundService.class);
                stopService(stopServiceIntent);
                break;
        }
    }
}
