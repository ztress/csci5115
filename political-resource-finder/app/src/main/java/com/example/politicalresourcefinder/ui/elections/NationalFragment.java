package com.example.politicalresourcefinder.ui.elections;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.politicalresourcefinder.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class NationalFragment extends Fragment {
    private Context mContext;

    ViewPager viewPager;
    TabLayout tabLayout;
    PageAdapter pageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_national, container, false);

        return root;

    }

    @Override
    public void onAttach(@NonNull Context context) {
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
//                        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Presidential Election");
//                        break;
//                    case 1:
//                        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Senate Election");
//                        break;
//                    case 2:
//                        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("House of Representatives Election");
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
        pageAdapter.addFragment(new PresidentFragment(), "President");
        pageAdapter.addFragment(new SenateFragment(), "Senate");
        pageAdapter.addFragment(new HouseFragment(), "House");

        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.setAdapter(pageAdapter);
    }
}
