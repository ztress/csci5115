package com.example.politicalresourcefinder.ui.elections;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.politicalresourcefinder.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ElectionsFragment extends Fragment {
    private Context mContext;

    private ElectionsViewModel electionsViewModel;

    //    Toolbar toolbar, toolbarTab;
    ViewPager viewPager;
    TabLayout tabLayout;
    PageAdapter pageAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        electionsViewModel = ViewModelProviders.of(this).get(ElectionsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_elections, container, false);
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

//                switch (tab.getPosition()) {
//                    case 0:
//                        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("National Elections");
//                        break;
//
//                    case 1:
//                        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Local Elections");
//                        break;
//                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        pageAdapter = new PageAdapter(getChildFragmentManager());
        pageAdapter.addFragment(new NationalFragment(), "National");
        pageAdapter.addFragment(new LocalFragment(), "Local");

        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.setAdapter(pageAdapter);
    }
}
