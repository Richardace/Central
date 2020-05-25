package com.example.central.veterinary.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModelVeterinary extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModelVeterinary() {
        mText = new MutableLiveData<>();
        mText.setValue("Esta es la pagina principal del Veterinaria");
    }

    public LiveData<String> getText() {
        return mText;
    }
}