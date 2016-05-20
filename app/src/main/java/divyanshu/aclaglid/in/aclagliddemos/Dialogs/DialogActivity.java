package divyanshu.aclaglid.in.aclagliddemos.Dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 13/05/16.
 */
public class DialogActivity extends FragmentActivity{

    Button dButton, alertfragbutton;
    FragmentManager fm = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_main);


        alertfragbutton = (Button)findViewById(R.id.alertfragbutton);
        dButton = (Button)findViewById(R.id.dbutton);


        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new AlertDialog.Builder(DialogActivity.this)
                        .setIcon(R.drawable.appicon1)
                        .setTitle("ACADGILD ALERT DIALOG")
                        .setMessage("Hello this is a message shown to users.........")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Toast.makeText(DialogActivity.this, "YES IS CLICKED....",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Toast.makeText(DialogActivity.this, "CANCEL IS CLICKED....",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

            }
        });

        alertfragbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDFragment alertFragment = new AlertDFragment();
                alertFragment.show(fm,"Alert Dialog Fragment");
            }
        });
    }
}
