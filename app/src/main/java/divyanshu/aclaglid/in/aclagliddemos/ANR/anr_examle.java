package divyanshu.aclaglid.in.aclagliddemos.ANR;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 27/05/16.
 */
public class anr_examle extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_anr);
    }


    public void throwANR(View view){
        long endTime = System.currentTimeMillis() + 20*1000;

        while(System.currentTimeMillis() < endTime){
            synchronized (this){
                try{
                    wait(endTime - System.currentTimeMillis());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        TextView mTextView = (TextView)findViewById(R.id.tcANR);
        mTextView.setText("Button Pressed");
    }
}
