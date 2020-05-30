package com.example.central.customer.inicio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModelCustomer extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModelCustomer() {
        mText = new MutableLiveData<>();
        mText.setValue("Esta es la pagina principal del Cliente");
    }

    public LiveData<String> getText() {
        return mText;
    }
}