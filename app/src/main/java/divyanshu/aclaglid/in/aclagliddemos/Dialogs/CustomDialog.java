package divyanshu.aclaglid.in.aclagliddemos.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 13/05/16.
 */
public class CustomDialog extends Activity {

    EditText etSearch;
    Button btncancel, btnsearch;
    Button dbutton;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_main);

        dbutton = (Button) findViewById(R.id.dbutton);
        dbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }


    public void showCustomDialog() {


        dialog = new Dialog(CustomDialog.this, android.R.style.Theme_Translucent);
        dialog.setContentView(R.layout.layout_customdialog);

        etSearch = (EditText) dialog.findViewById(R.id.etsearch);


        btnsearch = (Button) dialog.findViewById(R.id.btnsearch);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = etSearch.getText().toString().trim();
                if (TextUtils.isEmpty(userInput)) {
                    Toast.makeText(CustomDialog.this, "Please enter some value", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CustomDialog.this, userInput, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btncancel = (Button)dialog.findViewById(R.id.btncancel) ;
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
