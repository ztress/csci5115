package com.example.politicalresourcefinder.ui.elections;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NationalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NationalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the national fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
