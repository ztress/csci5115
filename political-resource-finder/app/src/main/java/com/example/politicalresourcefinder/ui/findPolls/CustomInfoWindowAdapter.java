package com.example.politicalresourcefinder.ui.findPolls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.politicalresourcefinder.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import androidx.fragment.app.FragmentActivity;

class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private final View church;
    private final View museum;
    private Context mContext;
    public CustomInfoWindowAdapter(Context context) {
        mContext = context;
        church = LayoutInflater.from(context).inflate(R.layout.fragment_concrete_location_church, null);
        museum = LayoutInflater.from(context).inflate(R.layout.fragment_concrete_location_museum, null);
        church.setLayoutParams(new LinearLayout.LayoutParams(300,150));
        museum.setLayoutParams(new LinearLayout.LayoutParams(300,150));
    }

    @Override
    public View getInfoWindow(Marker marker) {
        if(marker.getTitle().equals("University Lutheran Church")) {
            return church;
        } else if (marker.getTitle().equals("Weisman Art Museum")) {
            return museum;
        } else {
            return null;
        }
    }

    @Override
    public View getInfoContents(Marker marker) {
        if(marker.getTitle().equals("University Lutheran Church")) {
            return church;
        } else if (marker.getTitle().equals("Weisman Art Museum")) {
            return museum;
        } else {
            return null;
        }
    }


}
