package com.example.central.veterinary.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModelVeterinary extends ViewModel {

    private MutableLiveData<String> mText;

    public NotificationsViewModelVeterinary() {
        mText = new MutableLiveData<>();
        mText.setValue("Esta es la pagina de notificaciones del Veterinaria");
    }

    public LiveData<String> getText() {
        return mText;
    }
}