package com.example.politicalresourcefinder.ui.elections;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ElectionsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ElectionsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the elections fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
