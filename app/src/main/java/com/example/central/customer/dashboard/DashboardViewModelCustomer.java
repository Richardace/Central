package com.example.central.customer.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModelCustomer extends ViewModel {

    private MutableLiveData<String> mText;

    public DashboardViewModelCustomer() {
        mText = new MutableLiveData<>();
        mText.setValue("Este es el Dashboard del cliente");
    }

    public LiveData<String> getText() {
        return mText;
    }
}