package com.example.politicalresourcefinder.ui.howToVote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.politicalresourcefinder.R;

public class HowToVoteFragment extends Fragment {

    private HowToVoteViewModel howToVoteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        howToVoteViewModel =
                ViewModelProviders.of(this).get(HowToVoteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_how_to_vote, container, false);
        //final TextView textView = root.findViewById(R.id.text_how_to_vote);
        //howToVoteViewModel.getText().observe(this, new Observer<String>() {
        //    @Override
        //    public void onChanged(@Nullable String s) {
        //        textView.setText(s);
        //   }
        //});
        return root;
    }
}
