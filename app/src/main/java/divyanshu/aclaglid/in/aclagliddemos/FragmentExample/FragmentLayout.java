package divyanshu.aclaglid.in.aclagliddemos.FragmentExample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 20/05/16.
 */
public class FragmentLayout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this,"FragmentLayout onCreate() called",Toast.LENGTH_SHORT).show();

        setContentView(R.layout.activity_fragment_layout);

    }
}
