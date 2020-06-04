package com.example.politicalresourcefinder.ui.elections;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.politicalresourcefinder.R;

import java.util.ArrayList;

public class PresidentFragment extends Fragment {
    private Context mContext;

    private static final String TAG = "PresidentActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImage = new ArrayList<>();
    private ArrayList<String> mParty = new ArrayList<>();
    private ArrayList<String> mWebsite = new ArrayList<>();
    private ArrayList<String> mSlogan = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_candidates, container, false);

        recyclerSetup(root);

        return root;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void recyclerSetup(View view) {

        getImages();

        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImage, mParty, mWebsite, mSlogan, view.getContext(), view);
        recyclerView.setAdapter(adapter);

    }

    private void getImages() {
        //mImage.add("https://thumbs.dreamstime.com/b/young-man-suit-face-close-up-4941287.jpg");
        mNames.add("Tony Stark");
        mParty.add("PARTY: Engineer Party");
        mWebsite.add("WEBSITE: IronMan.com");
        mSlogan.add("SLOGAN: I am iron man");
        mImage.add(R.drawable.ironman);

        //mImage.add("https://www.goodfreephotos.com/albums/people/young-man-in-a-corporate-suit-face-portrait.jpg");
        mNames.add("Stephen Rogers");
        mParty.add("PARTY: Soldier Party");
        mWebsite.add("WEBSITE: CaptainAmerican.com");
        mSlogan.add("SLOGAN: I can do this all day");
        mImage.add(R.drawable.captainamerica);

        //mImage.add("https://www.goodfreephotos.com/cache/people/woman-in-white-shirt-holding-up-bitcoin_800.jpg");
        mNames.add("Carol Danvers");
        mParty.add("PARTY: Superman Party");
        mWebsite.add("WEBSITE: CaptainMarvel.com");
        mSlogan.add("SLOGAN: Higher, Further, Faster");
        mImage.add(R.drawable.capmarvel);

        //mImage.add("https://www.goodfreephotos.com/cache/people/glamour-portrait-of-young-man_800.jpg");
        mNames.add("T'Challa");
        mParty.add("PARTY: Wakanda Party");
        mWebsite.add("WEBSITE: BlackPanther.org");
        mSlogan.add("SLOGAN: American Forever!");
        mImage.add(R.drawable.blackpanther);

        //mImage.add("https://www.goodfreephotos.com/cache/people/woman-in-pink-dress-sitting-at-table_800.jpg");
        mNames.add("Stephen Strange");
        mParty.add("PARTY: Magician Party");
        mWebsite.add("WEBSITE: Kamar-Taj.com");
        mSlogan.add("SLOGAN: I've Come To Bargain");
        mImage.add(R.drawable.drstrange);

        // mImage.add("https://drive.google.com/open?id=1UjmhkTlNbQvtcG_OEtvaRPak0Czc6QT6");
        mNames.add("Peter Parker");
        mParty.add("PARTY: Friendly Neighbourhood Party");
        mWebsite.add("WEBSITE: SpiderMan.com");
        mSlogan.add("SLOGAN: with great power comes great responsibility");
        mImage.add(R.drawable.spiderman);

    }
}
