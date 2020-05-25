package com.example.central.veterinary.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModelVeterinary extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModelVeterinary() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el Dashboard del Veterinario");
    }

    public LiveData<String> getText() {
        return mText;
    }
}