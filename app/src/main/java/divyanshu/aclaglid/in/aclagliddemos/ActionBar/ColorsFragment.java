package divyanshu.aclaglid.in.aclagliddemos.ActionBar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import divyanshu.aclaglid.in.aclagliddemos.R;

public class ColorsFragment extends Fragment {

	TextView tvRed, tvBlue;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_colors, container, false);

		return rootView;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		tvRed = (TextView)getActivity().findViewById(R.id.txtRed);
		tvBlue=(TextView)getActivity().findViewById(R.id.txtBlue);

		tvRed.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tvRed.setVisibility(View.GONE);
				tvBlue.setVisibility(View.VISIBLE);
			}
		});

		tvBlue.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				tvRed.setVisibility(View.VISIBLE);
				tvBlue.setVisibility(View.GONE);
			}
		});
	}

}
