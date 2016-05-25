package divyanshu.aclaglid.in.aclagliddemos.ActionBar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import divyanshu.aclaglid.in.aclagliddemos.R;

public class ButtonsFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_buttons, container, false);
		
		return rootView;
	}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        Button bt=(Button)getActivity().findViewById(R.id.button1);
        bt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(getActivity().getApplicationContext(),"Clicked on Button", Toast.LENGTH_LONG).show();
            }
        });
    }
}
