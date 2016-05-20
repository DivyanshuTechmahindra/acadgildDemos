package divyanshu.aclaglid.in.aclagliddemos.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 13/05/16.
 */
public class AlertDFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        return  new AlertDialog.Builder(getActivity())
                .setIcon(R.drawable.appicon3)
                .setTitle("NEW TITLE IS SHOWN")
                .setMessage("Check your password")

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity().getBaseContext(),"OK IS CLICKED",Toast.LENGTH_SHORT).show();
                    }
                }).create();
    }

}
