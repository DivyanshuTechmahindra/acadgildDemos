package divyanshu.aclaglid.in.aclagliddemos.GPS;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 10/06/16.
 */
public class LocationActivity extends Activity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {


    private static  final String TAG ="LocationActivity";
    private static final int INTERVAL = 1000*10;
    private static final int FASTEST_INTERVAL = 1000 * 5;
    Button btnFusedLoation;
    TextView tvLocation;



    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    Location mCurrentLocation;
    String mLastUpdateTime;


    protected void createLocationRequest(){
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isGooglePlayServicesAvailable()){
            finish();
        }
        createLocationRequest();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        setContentView(R.layout.activity_location_gps);

        tvLocation = (TextView)findViewById(R.id.tvlocation);

        btnFusedLoation = (Button)findViewById(R.id.btnShowLocation);
        btnFusedLoation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUI();
            }
        });
    }


    private boolean isGooglePlayServicesAvailable(){
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if(ConnectionResult.SUCCESS == status){
            return true;
        }else{
            GooglePlayServicesUtil.getErrorDialog(status,this,0).show();
            return false;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    public void updateUI(){

        String address = "";String city = "";
        try {
            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(this, Locale.getDefault());

            addresses = geocoder.getFromLocation(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude(), 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5

             address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
             city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName();
        }catch (Exception e){
            e.printStackTrace();
        }

        if(null!=mCurrentLocation){
            String lat = String.valueOf(mCurrentLocation.getLatitude());
            String lng = String.valueOf(mCurrentLocation.getLongitude());
            tvLocation.setText(
                    "Address : "+address+"\n"+
                    "City : "+ city+"\n"+
                    "AT Time: "+mLastUpdateTime+"\n"+
            "Longitude :"+lng+"\n"+
            "Latitude : "+lat+"\n"+
            "Accuracy : "+ mCurrentLocation.getAccuracy()+"\n"+
            "Provider: "+mCurrentLocation.getProvider());
        }
    }

    @Override
    public void onConnected(Bundle bundle) {

        startLocationUpdates();
    }

    protected void startLocationUpdates(){
        PendingResult<Status> pendingResult = LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,mLocationRequest,this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

        mCurrentLocation = location;
        mLastUpdateTime = DateFormat.getTimeInstance().format(new Date());
        updateUI();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mGoogleApiClient.isConnected())
        stopLocationUpdates();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopLocationUpdates();
    }


    protected void stopLocationUpdates(){
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient,this);
    }
}
