package divyanshu.aclaglid.in.aclagliddemos.GoogleMapsExmplae;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import divyanshu.aclaglid.in.aclagliddemos.R;

/**
 * Created by divyanshu on 08/06/16.
 */
public class MapActivity extends FragmentActivity implements GoogleMap.OnMapClickListener {

    GoogleMap mMap; //Null

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlemap);
        setUpMapIfNeeded();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    protected void setUpMapIfNeeded(){
        if(mMap==null){
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

            if(mMap!=null){
                setUpMap();
            }

            mMap.setOnMapClickListener(this);
        }
    }

    private void setUpMap(){
        MarkerOptions marker  = new MarkerOptions().position(new LatLng(12.9716,77.5946)).title("ACADGILD");
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.appicon4));
//        mMap.addMarker(new MarkerOptions().position(new LatLng(12.9716,77.5946)).title("ACADGILD"));
        mMap.addMarker(marker);


        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(12.9716,77.5946));

        CameraUpdate zoom = CameraUpdateFactory.zoomTo(12);
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);



    }

    @Override
    public void onMapClick(LatLng latLng) {
        MarkerOptions marker  = new MarkerOptions().position(latLng).title("WELCOME TO BANGOLORE");
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.appicon12));
//        mMap.addMarker(new MarkerOptions().position(latLng).title("WELCOME TO BANGOLORE"));
        mMap.addMarker(marker);
    }
}
