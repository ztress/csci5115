package com.example.politicalresourcefinder.ui.elections;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LocalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LocalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the local fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
