package com.example.politicalresourcefinder.ui.howToVote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HowToVoteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HowToVoteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is how to vote fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
