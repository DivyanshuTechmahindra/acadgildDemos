package divyanshu.aclaglid.in.aclagliddemos.ExplicitIntent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 02/05/16.
 */
public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);


//        Bundle bundle = getIntent().getExtras();
//        String name = bundle.getString("USERNAME");

        String name = getIntent().getExtras().getString("USERNAME");

        TextView nameTV = (TextView) findViewById(R.id.name);

        nameTV.setText(name);
    }
}
