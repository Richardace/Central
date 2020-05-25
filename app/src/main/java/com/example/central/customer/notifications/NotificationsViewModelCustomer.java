package com.example.central.customer.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModelCustomer extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModelCustomer() {
        mText = new MutableLiveData<>();
        mText.setValue("Esta es la pagina de notificaciones del cliente");
    }

    public LiveData<String> getText() {
        return mText;
    }
}