package com.example.googlemap;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public abstract class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    SupportMapFragment mapFrag;
    private boolean mIsRestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mIsRestore = savedInstanceState != null;
        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
    }

    protected abstract void startDemo(boolean isRestore);

    protected GoogleMap getMap() {
        return mGoogleMap;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (mGoogleMap != null) {
            return;
        }
        mGoogleMap = googleMap;
        startDemo(mIsRestore);
    }
}

