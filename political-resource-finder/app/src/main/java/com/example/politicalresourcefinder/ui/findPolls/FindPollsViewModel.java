package com.example.politicalresourcefinder.ui.findPolls;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FindPollsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FindPollsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is find polls fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
