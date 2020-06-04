package com.example.politicalresourcefinder.ui.findPolls;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.example.politicalresourcefinder.MainActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.politicalresourcefinder.R;

public class FindPollsFragment extends Fragment {

    private FindPollsViewModel findPollsViewModel;
    private Marker home;
    private Marker church;
    private Marker museum;
    private ViewGroup vg;

    public FindPollsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vg = container;
        final View rootView = inflater.inflate(R.layout.fragment_find_polls, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frg);  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                if (MainActivity.showWelcome == false) {
                    View w = vg.findViewById(R.id.welcomePage);
                    w.setVisibility(View.GONE);
                } else {
                    View w = vg.findViewById(R.id.welcomePage);
                    w.setBackgroundColor(Color.WHITE);
                }
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                mMap.clear(); //clear old markers

                mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(getActivity()));
                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        marker.hideInfoWindow();
                    }
                });

                container.findViewById(R.id.getStartedBtn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        View c = vg.findViewById(R.id.welcomePage);
                        c.setVisibility(View.GONE);
                        MainActivity.showWelcome = false;
                    }
                });

                CameraPosition googlePlex = CameraPosition.builder()
                        .target(new LatLng(44.979845, -93.234379))
                        .zoom(15)
                        .bearing(0)
                        .tilt(0)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null);

                //initial new markers
                home = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(44.982167, -93.234962))
                        .title("You Are Here")
                        .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.homeicon)));


                church = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(44.983464, -93.235840))
                        .title("University Lutheran Church")
                        .snippet("#1 0.1 Miles"));

                museum = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(44.973057, -93.236946))
                        .title("Weisman Art Museum")
                        .snippet("#2 0.7 Miles"));

            }
        });
        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        MainActivity.showWelcome = false;
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
