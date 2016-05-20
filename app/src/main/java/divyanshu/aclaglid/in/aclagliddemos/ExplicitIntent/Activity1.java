package divyanshu.aclaglid.in.aclagliddemos.ExplicitIntent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 02/05/16.
 */
public class Activity1 extends Activity{
    Button button;
    EditText edit_query;
    String userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        edit_query = (EditText)findViewById(R.id.edit_query);

        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Bundle bundle = new Bundle();
//                bundle.putString("USERNAME","Prateek");

                userInput = edit_query.getText().toString();
                Intent mIntent = new Intent(Activity1.this,Activity2.class);
                mIntent.putExtra("USERNAME",userInput);
                mIntent.putExtra("SURNAME","Srivastava");
                startActivity(mIntent);

//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.acadgild.com"));
//                startActivity(intent);

            }
        });
    }



}
