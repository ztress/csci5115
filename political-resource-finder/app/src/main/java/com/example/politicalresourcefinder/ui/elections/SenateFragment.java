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

public class SenateFragment extends Fragment {
    private Context mContext;

    private static final String TAG = "SenateActivity";
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
        mNames.add("Candidate 1");
        mParty.add("PARTY: orange");
        mWebsite.add("WEBSITE: orangePresident.com");
        mSlogan.add("SLOGAN: if i add ice cream to water is it still ice cream?");
        mImage.add(R.drawable.candidate1);

        //mImage.add("https://www.goodfreephotos.com/albums/people/young-man-in-a-corporate-suit-face-portrait.jpg");
        mNames.add("Candidate 2");
        mParty.add("PARTY: yellow");
        mWebsite.add("WEBSITE: YellowFellow.com");
        mSlogan.add("SLOGAN: I can make america better with both hands tied behind my back?");
        mImage.add(R.drawable.candidate2);

        //mImage.add("https://www.goodfreephotos.com/cache/people/woman-in-white-shirt-holding-up-bitcoin_800.jpg");
        mNames.add("Candidate 3");
        mParty.add("PARTY: green");
        mWebsite.add("WEBSITE: meanGreenMachine.com");
        mSlogan.add("SLOGAN: If robots run america, then we can all go on vacation!");
        mImage.add(R.drawable.candidate3);

        //mImage.add("https://www.goodfreephotos.com/cache/people/glamour-portrait-of-young-man_800.jpg");
        mNames.add("Candidate 4");
        mParty.add("PARTY: maroon");
        mWebsite.add("WEBSITE: IAmYourPresident.org");
        mSlogan.add("SLOGAN: I was already your president and the world hasn't ended. so you should keep me.");
        mImage.add(R.drawable.candidate4);

        //mImage.add("https://www.goodfreephotos.com/cache/people/woman-in-pink-dress-sitting-at-table_800.jpg");
        mNames.add("Candidate 5");
        mParty.add("PARTY: purple");
        mWebsite.add("WEBSITE: RedAndBlue.com");
        mSlogan.add("SLOGAN: I am both republican and democrat i don't see why you wouldn't vote for me");
        mImage.add(R.drawable.candidate5);

        // mImage.add("https://drive.google.com/open?id=1UjmhkTlNbQvtcG_OEtvaRPak0Czc6QT6");
        mNames.add("Candidate 6");
        mParty.add("PARTY: grey");
        mWebsite.add("WEBSITE: NoGainNoPain.com");
        mSlogan.add("SLOGAN: Look presidents are pretty lame, I'll do literally nothing so at least it can't get any worse!");
        mImage.add(R.drawable.candidate6);

    }
}
