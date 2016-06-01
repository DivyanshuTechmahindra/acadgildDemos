package divyanshu.aclaglid.in.aclagliddemos.BroadcasrReceivers;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by divyanshu on 01/06/16.
 */
public class NotificationMessage extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView txt = new TextView(this);
        txt.setText("Welcome to Brooadcast receier in Acadgild.....");
        setContentView(txt);
    }
}
